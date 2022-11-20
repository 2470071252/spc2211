package cn.tedu.spring.service;

import cn.tedu.spring.anno.MyService;

@MyService
public class UserService {
    /**
     * @Override 让编译器检查后续方法是否为 重写
     * 仅仅在编译期间, 在源码上进行语法检查, 不需要
     * 传播到 class 和 运行期
     * @return
     */
    @Override
    public String toString() {
        return "userService";
    }
}
