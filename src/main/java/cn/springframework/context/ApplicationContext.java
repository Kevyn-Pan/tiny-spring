package cn.springframework.context;

import cn.springframework.beans.factory.ListableBeanFactory;

/**
 * @Classname ApplicationContext
 * @Description 如果仅添加BeanPostProcessor和BeanFactoryPostProcessor而不做任何包装，使用起来是比较麻烦的。因此通过此上下文操作类，
 *              把相应的XML加载、注册、实例化以及新增的修改和扩展都融合进去，让Spring可以自动扫描到我们的新增服务，便于用户使用
 *
 *           应用上下文{@link cn.springframework.context.support.ClassPathXmlApplicationContext}
 *          【 加载 -> XMl文件
 *          【 修改 -> Bean定义
 * refresh---
 *          【 注册 -> Bean扩展                 前置处理    】
 *          【 实例化 -> Bean对象 -----------> CreateBean  】--- BeanPostProcessor
 *                                             后置处理    】
 *
 * 过程：加载 -> 注册 -> 修改(Bean的定义信息) -> 实例化 -> 扩展(扩展Bean的实例化信息)
 * @Version 1.0.0
 * @Date 2023/1/3 09:34
 * @Created by kevynpan
 */
public interface ApplicationContext extends ListableBeanFactory {
}
