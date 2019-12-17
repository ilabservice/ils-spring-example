# ils-spring-example
这是一个 spring boot 的样本代码. 希望做 java 的服务端研发同学使用这个样本为模板来开发.

主要有一下几个方面的内容

## 异常类的定义
需要定义每个会被抛出的异常, 对应的 http 状态码.
在 GlobalExceptionHandler 中处理所有的异常类.
每一种逻辑异常都应该定义为枚举类 ResultErrorCode 中的一项, 包括错误码和错误串

## 异常返回消息
服务端做多语言处理. 客户端传入 header x-language. 服务端对每个语言维护一个 json 文件, 把错误串翻译为描述文字. 服务启动的时候加载.

原则上来讲: 只有暴露给网关的服务需要做语言处理. 更下层的服务, 只需要抛出异常.

## swagger 嵌入
我们用 swagger 来统一我们的接口文档. 在接口评审的时候, 开发可以使用这个模板做前期的定义. swagger 需要嵌入到以下几个方面
* controller 类的定义
* controller 方法的定义, 包括接口描述, 入参, 返回值
* model 已经 VO 里的类, 只要是会被作为返回值, 就需要用 swagger 的注释来解释.
