package org.example.backendproject.aop;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.example.backendproject.threadlocal.TraceIdHolder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect //공통으로 관리하고 싶은 기능을 담당하는 클래스에 붙히는 어노테이션
public class LogAspect {

  @Pointcut(
      "execution(* org.example.backendproject.board.service..*(..)) ||"+
          "execution(* org.example.backendproject.Auth.service..*(..)) ||"+
          "execution(* org.example.backendproject.user.service..*(..))")
  public void method() {
  }

  //PointCut
  @Around("method()")
  public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

    long start = System.currentTimeMillis();

    String methodName = joinPoint.getSignature().getName();

    try {
      log.info("[AOP_LOG][TraceID]{} {} 메서드 호출 시작 ", TraceIdHolder.get(), methodName);

      Object result = joinPoint.proceed();
      return result;
    } catch (Exception e) {
      log.error("[AOP_LOG][TraceId]{} {} 메서드 예외 {} ", TraceIdHolder.get(), methodName, e.getMessage());
      return e;
    } finally {
      long end = System.currentTimeMillis();
      log.info("[AOP_LOG][TraceId]{} {} 메서드 실행 완료 시간 = {}", TraceIdHolder.get(), methodName, end - start);
    }
  }
}
