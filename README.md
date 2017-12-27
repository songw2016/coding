# coding
# 程序猿收藏
###   前台（网站模板）
###   后台（后台管理模板）
###   H5（手机WAP站点模板）
###   简历页面
###   相册页面

# 常用开发工具下载
1. IDE(IDEA/eclipse or other)
2. mysql (5.6+)
3. mysql client(navicat/mysql workbeach)
4. SecureCRT SecureFX
5. jdk1.8
6. apache maven
7. tortoise svn 64位

# 代码规范
目录
### 1.Java规范(#JavaName)
### 2.Javascript规范(#JavascriptName)
### 3.Sql规范(#SqlName)

## <a name="JavaName">Java规范</a>

#### 1.【强制】 代码中的命名严禁使用拼音与英文混合的方式，更不允许直接使用中文的方式。
说明：正确的英文拼写和语法可以让阅读者易于理解，避免歧义。注意，即使纯拼音命名方式也要避免采用。不会的单词请[百度翻译](http://fanyi.baidu.com/)。    
反例： `DaZhePromotion [打折] / getPingfenByName() [评分] / int 某变量 = 3`   
正例： `alibaba / taobao / youku / hangzhou` 等国际通用的名称，可视同英文。     

---
#### 2. 类名使用 UpperCamelCase 风格（首字母大写），必须遵从驼峰形式。
正例：`MarcoPolo / UserDO / XmlService / TcpUdpDeal / TaPromotion `  
反例：`macroPolo / UserDo / XMLService / TCPUDPDeal / TAPromotion `  

---
#### 3. 方法名、参数名、成员变量、局部变量都统一使用 lowerCamelCase 风格（首字母小写），必须遵从驼峰形式。
正例： `localValue / getHttpMessage() / inputUserId`

---
#### 4. 【强制】常量命名全部大写，单词间用下划线隔开，力求语义表达完整清楚，不要嫌名字长。
正例： `MAX_STOCK_COUNT`    
反例： `MAX_COUNT`    

---
#### 5. 【强制】包名统一使用小写，点分隔符之间有且仅有一个自然语义的英语单词。包名统一使用单数形式，但是类名如果有复数含义，类名可以使用复数形式。
正例： 应用工具类包名为 com.java.open.util、类名为 MessageUtils（此规则参考spring 的框架结构）

---
#### 6. 杜绝完全不规范的缩写，避免望文不知义。
反例： `AbstractClass`“缩写”命名成 `AbsClass`；`condition`“缩写”命名成 `condi`，此类随意缩写严重降低了代码的可阅读性。

---
#### 7. 【推荐】如果使用到了设计模式，建议在类名中体现出具体模式。
说明：将设计模式体现在名字中，有利于阅读者快速理解架构设计思想。
正例：

```
	public class OrderFactory;
	public class LoginProxy;
	public class ResourceObserver;
```
---
#### 8. 枚举类名建议带上 Enum 后缀，枚举成员名称需要全大写，单词间用下划线隔开。
说明：枚举其实就是特殊的常量类，且构造方法被默认强制是私有。   
正例：枚举名字：`DealStatusEnum`，成员名称：`SUCCESS / UNKOWN_REASON`。   

---
#### 9. 【强制】 代码中的命名均不能以下划线或美元符号开始，也不能以下划线或美元符号结束。   
反例：` _name / __name / $Object / name_ / name$ / Object$`

---
#### 10. 【推荐】接口类中的方法和属性不要加任何修饰符号（public 也不要加），保持代码的简洁性，并加上有效的 Javadoc 注释

#### 11. 源代码文件以文件内容中的最顶层的Java类命名，而且大小写敏感，文件扩展名为 .java，同时，文件的编码格式统一为UTF-8。

#### 12. 类的命名遵循大驼峰命名法UpperCamelCase，而方法名和变量名的命名遵循小驼峰命名法lowerCamelCase
常量名使用大写字母表示，单词之间以下划线分隔，例如static final int CONNECTION_TIMEOUT = 10000

---
# 二.常量定义
#### 1. 【强制】不允许出现任何魔法值（即未经定义的常量）直接出现在代码中。
反例： 

```
String key = "Id#taobao_"+tradeId；
cache.put(key, value);
```

---

#### 2. 【强制】long 或者 Long 初始赋值时，必须使用大写的 L，不能是小写的 l，小写容易跟数字1 混淆，造成误解。
说明：Long a = 2l; 写的是数字的 21，还是 Long 型的 2?

---
#### 3. 【强制】不要使用一个常量类维护所有常量，应该按常量功能进行归类，分开维护。
如：缓存相关的常量放在类：CacheConsts 下；系统配置相关的常量放在类：ConfigConsts 下。   
说明：大而全的常量类，非得使用查找功能才能定位到修改的常量，不利于理解和维护。   

---
#### 4. 【推荐】常量的复用层次有五层：跨应用共享常量、应用内共享常量、子工程内共享常量、包内共享常量、类内共享常量。

```
1） 跨应用共享常量：放置在二方库中，通常是 client.jar 中的 constant 目录下。   
2） 应用内共享常量：放置在一方库的 modules 中的 constant 目录下。   
反例：易懂变量也要统一定义成应用内共享常量，两位攻城师在两个类中分别定义了表示“是”的变量：   
类 A 中：public static final String YES = "yes";   
类 B 中：public static final String YES = "y";   
A.YES.equals(B.YES)，预期是 true，但实际返回为 false，导致产生线上问题。      
3） 子工程内部共享常量：即在当前子工程的 constant 目录下。    
4） 包内共享常量：即在当前包下单独的 constant 目录下。    
5） 类内共享常量：直接在类内部 private static final 定义。    
```

---
#### 5.【推荐】如果变量值仅在一个范围内变化，且带有名称之外的延伸属性，定义为枚举类。下面
正例中的数字就是延伸信息，表示星期几。
正例：

```
public Enum { 
   MONDAY(1),
   TUESDAY(2),
   WEDNESDAY(3),
   THURSDAY(4), 
   FRIDAY(5), 
   SATURDAY(6),
   SUNDAY(7);
   }
```

# 三. 格式规约

#### 1. 【建议】缩进采用 4 个空格，禁止使用 tab 字符。
说明：如果使用 tab 缩进，必须设置 1 个 tab 为 4 个空格。IDEA 设置 tab 为 4 个空格时，请勿勾选 `Use tab character`；而在 eclipse 中，必须勾选 `insert spaces for tabs`。因为tab很容易造成代码对齐方式错乱,尤其在生成html文档的时候格式会乱掉。

---
#### 2. 【强制】单行字符数限制不超过 120 个，超出需要换行。

#### 3. Javadoc
标准的Javadoc常见的标记和含义如下：

```
/**
 * Javadoc常见的标记
 * 
 * @param 方法参数的说明
 * @return 对方法返回值的说明
 * @throws 方法抛出异常的藐视
 * @version 模块的版本号
 * @author 模块的作者
 * @see  参考方向
 * @deprecated 标记是否过时
 */
```


---

# 四. OOP规约
#### 1. 【强制】外部正在调用或者二方库依赖的接口，不允许修改方法签名，避免对接口调用方产生影响。接口过时必须加@Deprecated 注解，并清晰地说明采用的新接口或者新服务是什么。

---
#### 2. 【强制】定义 DO/DTO/VO 等 POJO 类时，不要设定任何属性默认值。
反例：POJO 类的 gmtCreate 默认值为 new Date(); , 但是这个属性在数据提取时并没有置入具体值，在更新其它字段时又附带更新了此字段，导致创建时间被修改成当前时间。

#### 3.  【强制】构造方法里面禁止加入任何业务逻辑，如果有初始化逻辑，请放在 init 方法中。

---
#### 4. 【强制】POJO 类必须写 toString 方法。使用 IDE 的中工具：source> generate toString时，如果继承了另一个 POJO 类，注意在前面加一下 super.toString。
说明：在方法执行抛出异常时，可以直接调用 POJO 的 toString()方法打印其属性值，便于排查问题。

---
#### 5. 【推荐】当一个类有多个构造方法，或者多个同名方法，这些方法应该按顺序放置在一起，便于阅读。

---
#### 6.【推荐】 类内方法定义顺序依次是：公有方法或保护方法 > 私有方法 > getter/setter方法。
说明：公有方法是类的调用者和维护者最关心的方法，首屏展示最好；    
保护方法虽然只是子类关心，也可能是“模板设计模式”下的核心方法；    
而私有方法外部一般不需要特别关心，是一个黑盒实现；    
因为方法信息价值较低，所有 Service 和 DAO 的 getter/setter 方法放在类体最后。  

---
#### 7.  【推荐】setter 方法中，参数名称与类成员变量名称一致，this.成员名 = 参数名。在getter/setter 方法中，不要增加业务逻辑，增加排查问题的难度。我曾天真的认为这种黑魔法很酷。
反例：

```
public Integer getData() {
if (true) {
return data + 100;
} else {
return data - 100;
	}
}   
```

---
#### 8. 【推荐】下列情况，声明成 final 会更有提示性：
1） 不需要重新赋值的变量，包括类属性、局部变量。   
2） 对象参数前加 final，表示不允许修改引用的指向。   
3） 类方法确定不允许被重写。  

---
#### 9. 【推荐】类成员与方法访问控制从严：
1） 如果不允许外部直接通过 new 来创建对象，那么构造方法必须是 private。  
2） 工具类不允许有 public 或 default 构造方法。     
3） 类非 static 成员变量并且与子类共享，必须是 protected。    
4） 类非 static 成员变量并且仅在本类使用，必须是 private。     
5） 类 static 成员变量如果仅在本类使用，必须是 private。    
6） 若是 static 成员变量，必须考虑是否为 final。     
7） 类成员方法只供类内部调用，必须是 private。        
8） 类成员方法只对继承类公开，那么限制为 protected。       
说明：任何类、方法、参数、变量，严控访问范围。过于宽泛的访问范围，不利于模块解耦。    

思考：如果是一个 private 的方法，想删除就删除，可是一个 public 的 service 方法，或者一个 public 的成员变量，删除一下，不得手心冒点汗吗？变量像自己的小孩，尽量在自己的视线内，变量作用域太大，如果无限制的到处跑，那么你会担心的。

---
# 四. 集合操作
#### 1. 【强制】不要在 foreach 循环里进行元素的 remove/add 操作。remove 元素请使用 Iterator方式，如果并发操作，需要对 Iterator 对象加锁。
反例：

```
List<String> a = new ArrayList<String>();
a.add("1");
a.add("2");
for (String temp : a) {
	if ("1".equals(temp)) {
		a.remove(temp);
		}
	}
```

正例：

```
Iterator<String> it = a.iterator();
while (it.hasNext()) {
	String temp = it.next();
	if (删除元素的条件) {
	it.remove();
		}
	} 
```

--- 
# 五.异常处理
#### 1.【推荐】方法的返回值可以为 null，不强制返回空集合，或者空对象等，必须添加注释充分说明什么情况下会返回 null 值。调用方需要进行 null 判断防止 NPE 问题。

--- 
#### 2. 【强制】对大段代码进行 try-catch，这是不负责任的表现。catch 时请分清稳定代码和非稳定代码，稳定代码指的是无论如何不会出错的代码。对于非稳定代码的 catch 尽可能进行区分异常类型，再做对应的异常处理。

--- 
#### 3. 【强制】捕获异常是为了处理它，不要捕获了却什么都不处理而抛弃之，如果不想处理它，请将该异常抛给它的调用者。最外层的业务使用者，必须处理异常，将其转化为用户可以理解的内容。

--- 
# 六. 日志
#### 1. 【强制】直接return的情况下一定要打日志,不然根本无法判断代码没有执行还是在哪个位置被return了。

---
#### 2. 【强制】异常信息应该包括两类信息：案发现场信息和异常堆栈信息。如果不处理，那么通过关键字 throws 往上抛出。
正例：logger.error(各类参数或者对象 toString + "_" + e.getMessage(), e);

---
#### 3. 【参考】可以使用 warn 日志级别来记录用户输入参数错误的情况，避免用户投诉时，无所适从。注意日志输出的级别，error 级别只记录系统逻辑出错、异常等重要的错误信息。如非必要，请不要在此场景打出 error 级别。

## <a name="JavascriptName">Javascript规范</a>

规范参考：
- [standard](https://github.com/feross/standard)
- [Airbnb JavaScript Style Guide](https://github.com/airbnb/javascript)

此规范Eslint配置: [eslint.json](/eslint.json)

sublime注释工具: [DocBlockr](https://github.com/Warin/Sublime/tree/master/DocBlockr)

## <a name="contents">目录</a>

  1. [命名](#name)
  1. [初始化](#init) 
  1. [函数](#function)
  1. [循环](#loop)
  1. [属性访问](#prop)
  1. [注释](#comment)
  1. [代码风格](#style)

---

## <a name="name">命名</a>
- 常规变量命名为驼峰式命名。
    ```javascript
    // bad 
    var citytext = '北京';
    var is_number = false;
    var has_selectCity = true; 

    // good
    var cityText = '北京';
    var isNumber = false;
    var hasSelectCity = true;
    ```
- 使用同义词替换需要使用的保留字。
    ```javascript
    // bad
    var superman = {
      class: 'alien'
    };
    var superman = {
      klass: 'alien'
    };

    // good
    var superman = {
      type: 'alien'
    };
    ```
- 避免单字母命名。命名应具备描述性。
    ```javascript
    // bad
    function q() {
      // // 一大坨代码stuff// 一大坨代码
    }

    // good
    function query() {
      // ..stuff..
    }
    ```
- 构造函数首字母大写。
    ```javascript
    // bad 
    var validate = function(el) {
        this.el = el;
        // 一大坨代码
    }; 
    // good
    var Validate = function(el) {
        this.el = el;
        // 一大坨代码
    };
    
    ```
- 使用下划线 _ 开头命名私有属性。
    ```javascript
    // bad
    this.__firstName__ = 'Panda';
    this.firstName_ = 'Panda';

    // good
    this._firstName = 'Panda';
    ```
- 使用`_this`来缓存当前作用域内`this`的引用。
    ```javascript
    // bad 
    function test() {
        var that = this;
        // var self = this;
        return function() {
            console.log(that)
        }
    }

    // good
    function test() {
        var _this = this;
        return function() {
            console.log(_this)
        }
    }
    ```
- `Boolean`类型的变量或属性以`is`/`has`开头。
    ```javascript

    // bad 
    var selected = false;
    var showCancel = false;
    var hotel = false;

    // good
    var isSelected = false;
    var isShowCancel = false;
    var hasHotel = false;

    ```
- 如果变量是`jquery`对象，变量名以`$`开头。
    ```javascript
    // bad
    var target = $('#target');
    // good
    var $target = $('#target');
    ```

**[⬆ 回到顶部](#contents)**

## <a name="init">初始化</a>
- 使用`{}`初始化对象字面量
    ```javascript
    // bad
    var obj = new Object();

    // good
    var obj = {};
    ```
    - 使用`[]`初始化数组
    ```javascript
    // bad
    var obj = new Array();

    // good
    var obj = [];
    ```

**[⬆ 回到顶部](#contents)**

## <a name="function">函数</a>
- 函数体避免过大，可拆分成几个职责清晰的单一函数(单一职责原则)。
    ```javascript
    // bad 
    function render() {
        // 一大坨渲染列表的代码
        // 一大坨渲染公告的代码
    };
    // good
    function render() {
        renderList();
        renderNotice();
    };
    function renderList() {
        // 渲染列表
    };
    function renderNotice(){
        // 渲染公告
    };
    ```
- 函数参数避免过多，当参数大于3个或参数中有`boolean`类型的值时，全部参数或可选参数使用配置对象代替。
    ```javascript
    // bad 
    function showDialog(el, data, target, className, isShowClose) {
        // 一大坨代码
    };

    // good
    function showDialog(option) {
        // 一大坨代码
    };
    showDialog({
        el: '#el', 
        target: '#target', 
        className: 'className', 
        isShowClose: true
    });
    ```
- 立即执行函数使用()来包裹，避免返回不必要的值。
    ```javascript
    // bad 
    !function iife() {
        // 一大坨代码
    }(); // 返回true
    +function iife() {
        // 一大坨代码
    }(); // 返回NaN
    -function iife() {
        // 一大坨代码
    }(); // 返回NaN

    // good
    (function iife() {
        // 一大坨代码
    })();
    ```
- 使用对象字面量给构造函数的原型对象添加属性，并指定`constructor`。
    ```javascript
    // bad 
    var Dog = function() {
    };
    Dog.prototype.eat = function() {

    };
    Dog.prototype.sleep = function() {

    };
    Dog.prototype.bark = function() {

    };

    // good
    var Dog = function() {
    };
    Dog.prototype = {
        constructro: Dog,
        eat: function() {
        },
        sleep: function() {
        },
        bark: function() {
        }
    };
    ```
- 如果你需要存取函数时使用 `get`和 `set` 作为函数名前缀。
    ```javascript
    // bad
    dragon.age();
    dragon.ageGet();
    dragon.ageSet();

    // good
    dragon.getAge();
    dragon.setAge(25);
    ```
- 如果属性是布尔值，使用 `is` 或 `has` 作为函数名的前缀。
    ```javascript
    // bad
    if (!dragon.age()) {
      return false;
    }

    // good
    if (!dragon.hasAge()) {
      return false;
    }
    ```

**[⬆ 回到顶部](#contents)**

## <a name="loop">循环</a>
- 迭代数组对象时，缓存数组的长度大小;
    ```javascript
    var arry = [];
    var i;
    var len;

    // bad 
    for(i = 0; i < arry.length; i++){
        //
    };
    // good
    for(i = 0, len = arry.length; i < len; i++){
    }
    ```
- 迭代聚合对象时，缓存当前值;
    ```javascript
    var arry = [];
    var i;
    var len;
    var current;

    // bad 

    for(i = 0, len = arry.length; i < len; i++){
        var name = arry[i].name;
        var age = arry[i].age;
        var sex = arry[i].sex;
    };
    // good
    for(var i = 0, len = arry.length; i < len; i++){
        current = arry[i];
        var name = current.name;
        var age = current.age;
        var sex = current.sex;
    };
    ```
- 在聚合对象中查找单个对象时，及时退出循环;
    ```javascript
    var arry;
    var i;
    var len;
    var targetId;
    // bad 
    for(i = 0, len = arry.length; i < len; i++){
        if(arry[i].id){
            // 一大坨代码
        }
    };
    // good
    for(i = 0, len = arry.length; i < len; i++){
        if(arry[i].id){
            // 一大坨代码
            break;
        }
    };
    ```
- 保持循环体清晰明了;
    ```javascript
    var arry = [];
    var i;
    var len;
    var current;

    // bad 
    for(var i = 0, len = arry.length; i < len; i++){
        if(i>5){
            // 一大坨逻辑
        }else{
            // 一大坨逻辑
        }
    };
    // good
    for(var i = 0, len = arry.length; i < len; i++){
        if(i<10){
            doSomething();
        }else{
            doAnotherthing();
        }
    };
    function doSomething() {
        // 一大坨代码
    };
    function doAnotherthing() {
        // 一大坨代码
    };
    ```

**[⬆ 回到顶部](#contents)**

## <a name="prop">属性访问</a>
- 使用 . 来访问对象的属性。
    ```javascript
    var luke = {
      jedi: true,
      age: 28
    };

    // bad
    var isJedi = luke['jedi'];

    // good
    var isJedi = luke.jedi;
    ```
- 当通过变量访问属性时使用中括号 []。
    ```javascript
    var luke = {
      jedi: true,
      age: 28
    };

    function getProp(prop) {
      return luke[prop];
    }

    var isJedi = getProp('jedi');
    ```

**[⬆ 回到顶部](#contents)**

## <a name="comment">注释</a>
- 函数描述注释。
    ```javascript
    /**
     * [testFunction description]
     * @param  {[type]} a [description]
     * @param  {[type]} b [description]
     * @param  {[type]} c [description]
     * @return {[type]}   [description]
     */
    function testFunction(a, b, c) {
    }
    ```
- 单行注释。
    ```javascript
    //bad 
    /* 初始化项目 */
    function init() {
      // 一大坨代码
    }
    //初始化项目
    function init() {
      // 一大坨代码
    }
    // good
    // 初始化项目
    function init() { 
      // 一大坨代码
    }
    ```
- 多行注释。
    ```javascript
    //bad 
    function init() {
      // 一大坨代码
    }
    // 初始化项目
    // 并获取数据
    function init() {
      // 一大坨代码
    }
    // good
    /* 
      初始化项目 
      并获取数据
    */
    function init() {
      // 一大坨代码  
    }
    ```

**[⬆ 回到顶部](#contents)**

## <a name="style">代码风格</a>
- 使用4格`tab`缩进。
    ```javascript
    // bad
    function test() {
      var name = 'naraku';
      switch(name){
        case 'haha':
          console.log(name);
          break;
      }
    };
    // good
    function test() {
        var name = 'naraku';
        switch(name){
            case 'haha':
            console.log(name);
            break;
        }
    };
    ```
- 使用单引号` '' `包裹字符串。
    ```javascript
    // bad
    var name = "Bob Parr";
    var fullName = "Bob " + this.lastName;

    // good
    var name = 'Bob Parr';
    var fullName = 'Bob ' + this.lastName;
    ```
- 使用 `var` 声明每一个变量。
    ```javascript
    // bad
    var items = getItems(),
        goSportsTeam = true,
        dragonball = 'z';

    // bad
    // （跟上面的代码比较一下，看看哪里错了）
    var items = getItems(),
        goSportsTeam = true;
        dragonball = 'z';

    // good
    var items = getItems();
    var goSportsTeam = true;
    var dragonball = 'z';
    ```
- 最后再声明未赋值的变量。当你需要引用前面的变量赋值时这将变的很有用。
    ```javascript
    // bad
    var i, len, dragonball,
        items = getItems(),
        goSportsTeam = true;

    // bad
    var i;
    var items = getItems();
    var dragonball;
    var goSportsTeam = true;
    var len;

    // good
    var items = getItems();
    var goSportsTeam = true;
    var dragonball;
    var length;
    var i;
    ```
- 使用大括号包裹所有的多行代码块。
    ```javascript
    // bad
    if (test)
      return false;

    // good
    if (test) return false;

    // good
    if (test) {
      return false;
    }

    // bad
    function nameBad() { return false; }

    // good
    function nameGood() {
      return false;
    }
    ```
- 把 else 放在 if 代码块关闭括号的同一行。
    ```javascript
    // bad
    if (test) {
      thing1();
      thing2();
    }
    else {
      thing3();
    }

    // good
    if (test) {
      thing1();
      thing2();
    } else {
      thing3();
    }
    ```
- 在大括号前放一个空格。
    ```javascript
    // bad
    function test(){
      console.log('test');
    }

    // good
    function test() {
      console.log('test');
    }

    // bad
    dog.set('attr',{
      age: '1 year',
      breed: 'Bernese Mountain Dog'
    });

    // good
    dog.set('attr', {
      age: '1 year',
      breed: 'Bernese Mountain Dog'
    });
    ```
- 在控制语句（if、while 等）的小括号前放一个空格。在函数调用及声明中，不在函数的参数列表前加空格。
    ```javascript
    // bad
    if(isJedi) {
      fight ();
    }

    // good
    if (isJedi) {
      fight();
    }

    // bad
    function fight () {
      console.log ('Swooosh!');
    }

    // good
    function fight() {
      console.log('Swooosh!');
    }
    ```
- 使用空格把运算符隔开。
    ```javascript
    // bad
    var x=y+5;
    var result=isOk?'ok':'no';

    // good
    var x = y + 5;
    var result = isOk ? 'ok' : 'no';
    ```
- 自增/自减运算符不需要隔开。
    ```javascript
    // bad
    var x = y ++;

    // good
    var x = y++;
    ```
- 使用三元运算符时，保证他们在同一行或者`?`,`:`单独一行不分开。
    ```javascript
    // bad
    var location = env.development ?
      'localhost' :
      'www.api.com';

    // good
    var location = env.development ? 'localhost' : 'www.api.com'

    var location = env.development
      ? 'localhost'
      : 'www.api.com';

    ```
- 使用行尾逗号。
    ```javascript
    // bad
    var story = [
        once
      , upon
      , aTime
    ];

    // good
    var story = [
      once,
      upon,
      aTime
    ];

    // bad
    var hero = {
        firstName: 'Bob'
      , lastName: 'Parr'
      , heroName: 'Mr. Incredible'
      , superPower: 'strength'
    };

    // good
    var hero = {
      firstName: 'Bob',
      lastName: 'Parr',
      heroName: 'Mr. Incredible',
      superPower: 'strength'
    };
    ```
- 去除额外的尾部逗号。
    
    ```javascript
    // bad
    var hero = {
      firstName: 'Bob',
      lastName: 'Parr',
      heroName: 'Mr. Incredible',
      superPower: 'strength',
    };
    var arry = ['a', 'b', 'c',]
    // good
    var hero = {
      firstName: 'Bob',
      lastName: 'Parr',
      heroName: 'Mr. Incredible',
      superPower: 'strength'
    };
    var arry = ['a', 'b', 'c']
    ```
- 在每一个语句后使用分号。
    ```javascript
    // bad
    (function () {
      var name = 'Skywalker'
      return name
    })()

    // good
    (function () {
      var name = 'Skywalker';
      return name;
    })();
    ```

## <a name="SqlName">Sql规范</a>

1. [基本规范](#1-基本规范)
2. [性能约束](#2-性能约束)

---

## 1 基本规范

## 1.1. 数据库

- 名称使用英文小写和下划线分割的规则, **必须**以复数形式结尾, 字段长度不能超过3个单词长度, 单个单词长度超过10个字母的应当使用缩写；

- 如没有特殊的需求，尽量采用 `utf8` 作为默认字符集。

- 坚持最小权限控制原则。

- 设计数据库时遵循范式化设计，至少达到第三范式，特殊情况下可以让极少数的字段冗余。

### 1.2. 数据表

- 必须使用 `项目名_模块名_表名` 来作为数据表的完整名称，且必须使用英文全名，并且采用小写和下划线分割的规则，如果真的太长需要缩写，则采用首4个字母，尽量做到语义要明确，不能让人产生困惑。

- **必须**要有表注释。

- 如非必要，**必须**采用 `utf8` 字符集。

- 如没有特殊需求，尽量采用 `innodb` 引擎。

- 每个表都**必须**有一个自增主键 `id`。

- 每个表都**必须**有 `create_time` 字段，字段类型**必须**为 `int(10)`，字段值必须为时间戳。
 
- 每个表都**必须**有 `update_time` 字段，字段类型**必须**为 `int(10)`，字段值必须为时间戳。

- 每个表都**必须**有 `create_user` 字段，字段类型**必须**为 `int` ，字段长度**必须**设置为 `11`。
 
- 每个表都**必须**有 `update_user` 字段，字段类型**必须**为 `int`，字段长度**必须**设置为 `11`。

- 每个表都**必须**有 `del_flg` 字段，字段类型**必须**为 `tinyint` ，默认是必须设置为 `0`。

### 1.3. 字段

- 字段名采用规范的英文小写格式，并且以下划线”_”分割，长度不能超过3个单词长度，单个单词长度超过10个字母的应当使用缩写，**禁止**使用mysql的关键字作为字段名， 正确的例子如 `user_id`、`room_type`。

- `timestamp、image、datetime、smalldatetime、uniqueidentifier、binary、sql_variant、binary、varbinary` 外，必须有默认值。

- 如非必要，所有字段**必须**设为 `not null`。

- 字符型的默认值为一个空字符值串 `''`。
 
- 数值型的默认值为数值 `0` (具体看业务可以用其他数值)。

- 系统中所有逻辑型中数值 `0` 表示为“假”；数值 `1` 表示为“真”。

- 每个字段**必须**要有注释。

- 很多表的字段是类似的，如时间字段（创建时间，最后一次修改时间等），此时每一个表的命名都应该一致且类型也应该一致，如不能这个表使用 `int` 类型，那个表使用 `timestamp` 类型，另外的表又使用 `datetime` 类型，这个表命名 `created_at`，那个表命名 `create_time`。

---

## 2 性能约束

数据库的性能优化是个很庞大的话题，特别指出的是在设计数据库和查询时要时刻注意性能，因为大多数情况下，出现性能瓶颈的问题都在数据库的读写上，这方面的知识请查看相关的文章和书籍。

以下是一些基本的注意事项：

- **禁止**查询语句用 `*` 通配符。