package pl.mzuchnik.springpracadomowa9.advice;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeProcessingAspect {

    private long startTime;

    @Before("@annotation(getProcessingTime)")
    public void startCountTime(GetProcessingTime getProcessingTime) {
        startTime = System.currentTimeMillis();
    }

    @After("@annotation(getProcessingTime)")
    public void endCountTime(GetProcessingTime getProcessingTime){
        startTime = System.currentTimeMillis() - startTime;
        System.out.println(getProcessingTime.name() + " : " + startTime + " ms");
    }
}
