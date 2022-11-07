package com.gdu.app08.aop;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component	// RequestLoggingAspect 클래스를 Bean으로 만들어 두시오.
@Aspect		// 안녕. 난 Aspect야. AOP 동작하려면 내가 필요해.
public class RequestloggingAspect {
	
	// 로거
	private static final Logger LOG = LoggerFactory.getLogger(RequestloggingAspect.class);
	
	
	@Pointcut("within(com.gdu.app08.controller..*)")	// controller의 모든 메소드를 포인트컷 지정하겠다
														// contooller의 모든 메소드에서 어드바이스(콘솔에 로그 찍기)가 동작한다.
	
	public void setPointCut() {}		// 오직 포인트컷 대상을 결정하기 위한 메소드(이름 : 아무거나, 본문 : 없음)
	
	
	// 어드바이스 설정
	// 어드바이스 실행 시점
	// @Before, @After, @afterReturning, @AfterThrowing, @Around
	@Around("com.gdu.app08.aop.RequestLoggingAspect.setPointCut()")	// setPointCut() 메소드에 설정된 포인트컷에서 동작하는 어드바이스
	public Object executeLogging(ProceedingJoinPoint joinPoint) throws Throwable { // @Around는 반드시 ProceedingJoinPoin joinPoin 선언해야함
		
		// HttpServletRequest를 사용하는 방법
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		
		// HttpServletRequest를 Map으로 바꾸기
		// 파라미터는 Map의 Key가 되고, 값은 Map의 value가 된다.
		Map<String, String[]> map = request.getParameterMap();
		String params = "";
		if(map.isEmpty()) {
			params += "[No parameter]";
		} else {
			for(Map.Entry<String, String[]> entry : map.entrySet()) {
				params += "[" + entry.getKey() + "=" + String.format("%s", (Object[])entry.getValue()) + "]";
				// %s = 문자열을 출력할게요. 라는 약속
			}
		}
		
		// 어드바이스는 proceed() 메소드 실행 결과를 반환
		Object result = null;
		try {
			result = joinPoint.proceed(joinPoint.getArgs());
		} catch(Exception e) {
			throw e;
		} finally {
			// 무조건 실행되는 영역. 여기서 로그를 찍는다.)
			// 치환문자 : {}
			LOG.info("{} {} {} > {}", request.getMethod(), request.getRequestURI(), params, request.getRemoteHost());
		}
		
		return result;
	}
	

}
