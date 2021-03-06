[TOC]

---

# 4. SpringMVC核心技术

## 4.1请求转发与重定向

-   当处理器对请求处理完毕后，向其它资源进行跳转时，有两种跳转方式：**请求转发**与**重定向**
    -   根据所要跳转的资源类型，又可分为两类：**跳转到页面**与**跳转到其它处理器**
    -   **请求转发可以访问WEB-INF中的资源**,重定向不能
    -   请求转发只有一次请求,一次响应,由请求的资源1在服务器内再此请求资源2,资源2来响应浏览器,转发的路径为服务器内路径
    -   重定向有两次请求两次响应,第一次请求资源1,资源1响应后,再次请求资源2,资源2再响应,重定向路径为外部访问路径

### 4.1.1 返回 ModelAndView 时的请求转发

-   默认情况下，当处理器方法返回 ModelAndView 时，跳转到指定的 View，使用的是**请求转发**,当然也可以显式的进行指出

    -   在 setViewName()指定的视图前**添加`forward:`**，且此时的视图**不会再与视图解析器中的前辍与后辍进行拼接**;**必须写出相对于项目根的路径**

    -   ```java
        modelAndView.setViewName("forward:/WEB-INF/jsp/show.jsp");
        ```

-   请求转发到其他Controller

    -   ```java
        modelAndView.setViewName("forward:other.do");
        ```

1.  请求转发到页面

    -   当通过请求转发跳转到目标资源（页面或 Controller）时，若需要**向下传递数据**，除了可以使用 request，session外，还可以将数据存放于 ModelAndView中的 **Model中**。页面通过**EL 表达式可直接访问该数据**

    1.  修改处理器类ForwardController

        ```java
        @Controller
        @RequestMapping("/test")
        public class ForwardController {
            @RequestMapping("/forward.do")
            public ModelAndView fordward(User user) {
                ModelAndView modelAndView = new ModelAndView();
                modelAndView.addObject("user", user);
                modelAndView.setViewName("forward:/web-resources/forward.jsp");
                return modelAndView;
            }
        }
        ```

    2.  修改 springmvc 配置文件

        ```xml
            <!--注册组件扫描器:组件即处理器-->
            <context:component-scan base-package="com.sqm.annotation.*"/>
            <!--注册内部资源视图解析器-->
            <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
            </bean>
        ```

2.  请求转发到其它 Controller

    ```java
    @Controller
    @RequestMapping("/test")
    public class ForwardToAnotherControllerController {
        @RequestMapping("/some.do")
        public ModelAndView doSome(User user) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("user", user);
            modelAndView.setViewName("forward:other.do");
            return modelAndView;
        }
    	
        @RequestMapping("/other.do")
        public ModelAndView doOther() {
            return new ModelAndView("forward:third.do");
        }

    	@RequestMapping("/third.do")
        public ModelAndView doThird(User user) {
          	System.out.println("user =" + user);
            return new ModelAndView("forward:/web-resources/forward.jsp");
        }
    }
    ```

### 4.1.2 返回 ModelAndView 时的重定向

-   重定向到页面


-   重定向到其他Controller
-   **重定向到页面:**
    1.  通过 ModelAndView 的 Model 携带参数
        1.  修改处理器类 MyController
        2.  修改 show 页面位置
        3.  修改 show 页面内容
    2.  使用 HttpSession 携带参数
        1.  修改处理器类
        2.  修改 show页面
-   **重定向到Controller:**
    1.  通过ModelAndView的Model 携带参数
        1.  直接修改处理器类
    2.  使用 HttpSession 携带参数
        1.  直接修改处理器类

### 4.1.3  返回 String 时的请求转发

1.  修改处理器类
2.  修改 show 页面

### 4.1.4 返回String时的重定向

1.  重定向到页面
    1.  通过 Model 形参携带参数
        1.  修改处理器类
        2.  修改 show 页面


    1.  通过形参 RedirectAttributes 的 addAttribute()携带参数
        1.  修改处理器类
        2.  修改 springmvc 配置文件

2.  重定向到 Controller

    1.  通过 Model 形参携带参数
        1.  修改处理器类
        2.  修改 show页面
    2.  通过形参 RedirectAttributes的addFlushAttribute()携带参数(了解)
        1.  修改处理器类
        2.  修改 show页面
        3.  修改 springmvc 配置文件
        4.  运行

### 4.1.5 返回void 时的请求转发

1.  修改处理器类
2.  修改 show 页面

### 4.1.6 返回void 时的重定向

1.  修改处理器类
2.  修改 show 页面

## 4.2 异常处理

### 4.2.1 SimpleMappingExceptionResolver 异常处理器

1.  自定义异常类
    -   定义三个异常类：NameException、AgeException、StudentException。其中 StudentException是另外两个异常的父类
2.  修 改 Controller
3.  注册异常处理器
4.  定义异常响应页面

### 4.2.2 自定义异常处理器

1.  定义异常处理器
2.  注册异常处理器

### 4.2.3 异常处理注解

1.  定义异常处理的Controller
2.  修改Controller

## 4.3 类型转换器

### 4.3.1 搭建测试环境

1.  修改index页面
2.  修改处理器类
3.  修改show页面
4.  修改SpringMVC配置文件

### 4.3.2  自定义类型转化器

### 4.3.3 对类型转换器的配置

1.  注册类型转换器
2.  创建转换服务Bean
3.  使用转换服务Bean
4.  SpringMVC配置文件的总配置

### 4.3.4 接收多种日期格式的类型转换器

### 4.3.5 数据回显

1.  修改处理器
2.  修改页面表单
3.  修改类型转换器

### 4.3.6 自定义类型转换失败后的提示信息

1.   修改处理器
    1.  定义一个方法
    2.  修改异常处理方法

## 4.4 数据验证

### 4.4.1 搭建测试环境

1.  导入jar包
2.  定义实体
3.  定义index,修改index
4.  定义show页面
5.  定义SpringMVC配置文件

### 4.4.2 实现数据验证

1.  修改springmvc配置文件
2.  在实体属性上添加验证注解
3.  修改Controller
4.  页面显示验证异常信息

## 4.5 文件上传

### 4.5.1 上传单个文件

1.  导入jar包
2.  定义上传页面
3.  定义处理器
    1.  处理器方法的形参
    2.  为选择上传文件
    3.  上传文件类型
    4.  上传方法
4.  在SpringMVC中注册文件上传处理器
    1.  bean名称固定
    2.  文件上传字符集
    3.  限定文件大小
5.  设置文件超出大小的异常处理
    1.  注册异常处理器
    2.  定义异常响应页面
6.  定义上传成功与失败页面

### 4.5.2 上传多个文件

1.  修改index
2.  修改处理器类
    1.  处理器方法的形参
    2.  未选择上传文件

## 4.6 拦截器

### 4.6.1 一个拦截器的执行

1.  自定义拦截器
2.  注册拦截器
3.  修改index页面
4.  修改处理器
5.  修改show页面
6.  控制台输出结果

### 4.6.2 多个拦截器执行

1.  再定义一个拦截器
2.  多个拦截器注册与执行
3.  控制台输出结果
4.  阅读源码

### 4.6.3 权限拦截器举例

1.  修改index
2.  定义Controller
3.  定义welcome页面
4.  定义权限拦截器
5.  定义fail页面
6.  注册权限拦截器
7.  定义login页面
8.  定义logout页面
9.  项目测试





