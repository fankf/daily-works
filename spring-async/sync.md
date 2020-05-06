### 异步方法添加
 1. 开启异步功能 @EnableAsync
 2. 编辑服务 @Service
 3. 在类上或方法上添加 @Async
 ### 限制
 * 默认类的调用不会被AOP拦截，也就是说同类调用不会生效
 * 解决方案：当获取Spring 的Bean的时候会生效。
 
 SimpleAsyncTaskExecutor 异步方法实质上开启一个新线程工作