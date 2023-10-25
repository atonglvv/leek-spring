package cn.atong.leek.spring.aop.aspectj;

import cn.atong.leek.spring.aop.Pointcut;
import cn.atong.leek.spring.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * @program: leek-spring
 * @description: Spring AOP Advisor that can be used for any AspectJ pointcut expression.
 * @author: atong
 * @create: 2023-10-25 16:26
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    // 切面
    private AspectJExpressionPointcut pointcut;
    // 具体的拦截方法
    private Advice advice;
    // 表达式
    private String expression;

    public void setExpression(String expression){
        this.expression = expression;
    }

    @Override
    public Pointcut getPointcut() {
        if (null == pointcut) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice){
        this.advice = advice;
    }

}

