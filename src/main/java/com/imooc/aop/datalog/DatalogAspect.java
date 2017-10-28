package com.imooc.aop.datalog;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DatalogAspect {

    private static final Logger logger = LoggerFactory.getLogger(DatalogAspect.class);

    @Autowired(required=false)
    ActionDao actionDao;

    @Pointcut("execution(public * com.imooc.aop.dao.*.save*(..))")
    public void save(){

    }

    @Pointcut("execution(public * com.imooc.aop.dao.*.delete*(..))")
    public void delete(){

    }

    /**
     * 1\判断是什么类型的操作,增加\删除\还是更新
     *  增加/更新 save(Product),通过id区分是增加还是更新
     *  删除delete(id)
     * 2\获取changeitem
     *   (1)新增操作,before直接获取,after记录下新增之后的id
     *   (2)更新操作,before获取操作之前的记录,after获取操作之后的记录,然后diff
     *   (3)删除操作,before根据id取记录
     * 3\保存操作记录
     *    actionType
     *    objectId
     *    objectClass
     * @param pjp
     * @return
     * @throws Throwable
     */
    @After("save() || delete()")
    public Object addOperateLog() throws Throwable {
        Object returnObj = null;

       // String method = pjp.getSignature().getName();
        try{

                //insert or update
                ///Object obj = pjp.getArgs()[0];


            //returnObj = pjp.proceed(pjp.getArgs());
System.out.println("after");

        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }

        return returnObj;
    }
    
    @Around("save() || delete()")
    public Object addOperateLog1(ProceedingJoinPoint pjp) throws Throwable {
        Object returnObj = null;

        String method = pjp.getSignature().getName();
        try{

                //insert or update
                Object obj = pjp.getArgs()[0];


                System.out.println("befor  in");
            returnObj = pjp.proceed(pjp.getArgs());
            System.out.println("after  in");


        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }

        return returnObj;
    }
}
