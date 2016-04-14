# Ajax_summarize

## 有关ajax的用法及其应用的总结

### 一、 Ajax 部分介绍
	
	1. 什么是 Ajax
		不用刷新页面，但是可以和服务器进行通信的方式，实现 Ajax 的主要方式为 XMLHttpRequest 对象
	
	2. 使用 XMLHttpRequest 对象实现 Ajax [了解，实际的开发中通常不用]
	
	3. Ajax 传输数据的 3 种方式
		
		<1> XML : 笨重, 解析困难，但是 XML 是通用的数据交换格式
		<2> HTML : 不需要解析可以直接放到文档中，若仅更新一部分区域. 但是传输的数据有限，
				且 HTML 代码需要拼装完成
		<3> JSON : 小巧，有面向对象的特征，且有很多第三方的 jar 包可以把 Java 对象或集合转为 JSON 字符串
		
	4. 使用 jQuery 完成 Ajax 操作
		
		<1> load 方法 : 可以用于 HTML 文档的元素节点，把结果直接加为对应节点的子元素，
			     通常而言，load 方法加载后的数据是一个 HTML 片段
			     例： 
			     var $obj = ...
			     var url = ...
			     var agrs = { key : value }
			     $obj.load(url, agrs)	
			   
		<2> 
			① $.get ② $.post ③ $.getJSON : 
				更加的灵活，除去使用 load 的情况，大部分时候使用这三个方法
			
			举例：
				I. 基本的使用
					// url : Ajax 请求的目标 URL
					// args : 传递的参数 : JSON 类型
					// data : Ajax 响应成功后的数据，可能是 XML, HTML, JSON
					$.get(url, args, function(data){
				
					})
					
				II. 使用 JSON 数据
					此时的方法可以有三种写法：
				   <1> $.getJSON(url, args, function(data){...})
				   <2> $.get(url, args, function(data){...}, "json")
				   <3> $.post(url, args, function(data){...}, "json")

### 二、 关于xmlhttprequest的readystate属性的五个状态

		创建 xmlhttprequest 对象之后没有调用 open之 前readystate值为0，
	调用 open()之后就变为1了，并且此时 onreadystatechange 函数与 open() 
	几乎是同时执行的。
	
		在之后调用 send 方法之后，在 startHttpRequest 函数中 readystate 
	值仍为 1 ，而调用 send 方法之后应该有 2，3，4三个状态，而只有在 startHttpRequest 
	函数用alert语句才可以观察到3个值！这是为什么呢? 
	
		这是因为在 startHttpRequest 函数中当解析到send 这一句时，并没有真正开始 send 
	执行。只有 send 执行，才可以在 onreadystatechange 函数观察到状态值的变化。
	readystate 不是发送的状态，它是准备发送的状态，要把它想像成“人间大炮一级准备、二级准备、放”
	这样的口号，不是请求发送本身。同时 xmlhttp 也不是监听服务器信息，它是在 send 的时候获取服务器
	返回的状态信息而已，只有一次，监听则是一直在观察状态。至此，心中的疑惑全部解开！

	关于readystate五个状态总结如下：
	
		readyState 的状态说明：
			
			(0)未初始化
					此阶段确认XMLHttpRequest对象是否创建，并为调用open()方法进行未初始化作好准备。
				值为0表示对象已经存在，否则浏览器会报错－－对象不存在。
				
			(1)载入
					此阶段对XMLHttpRequest对象进行初始化，即调用open()方法，
				根据参数(method,url,true)完成对象状态的设置。并调用send()方法
				开始向服务端发送请求。值为1表示正在向服务端发送请求。
			
			(2)载入完成
					此阶段接收服务器端的响应数据。但获得的还只是服务端响应的原始数据，并不能直接在客户端使用。
				值为2表示已经接收完全部响应数据。并为下一阶段对数据解析作好准备。
			
			(3)交互
					此阶段解析接收到的服务器端响应数据。即根据服务器端响应头部返回的 MIME 类型把数据转换成
				能通过responseBody、responseText或responseXML属性存取的格式，为在客户端调用作
				好准备。状态3表示正在解析数据。
			
			(4)完成
					此阶段确认全部数据都已经解析为客户端可用的格式，解析已经完成。值为4表示数据解析完毕，
				可以通过XMLHttpRequest对象的相应属性取得数据。
			
			概而括之，整个XMLHttpRequest对象的生命周期应该包含如下阶段：
			
				创建－初始化请求－发送请求－接收数据－解析数据－完成
				

### 三、 Ajax 中数据格式的总结
	
	1. 数据格式为 HTML 的形式
		
		<1>. 优点：
			
			① 从服务器端发送的 HTML 代码在浏览器不需要用 JavaScript 进行解析
			② HTML 的可读性好
			③ HTML 代码块与 innerHtml 属性搭配，效率高
		
		<2>. 缺点：
			
			① 若需要通过 AJAX 更新一片文章	
			
	2. 数据格式为 XML 的形式
		
		<1> 优点：
			
			① XML 是一种通用的数据格式
			② 不必把数据强加到已定义好的格式中，而是要为数据自定义合适的标记
			③ 利用 DOM 可以完全掌控文档
		
		<2> 缺点：
		
			① 如果文档来自于服务器，就必须得保证文档含有正确的首部信息，
			      若文档类型不正确，那么 responseXML 的值将是空的
			② 当浏览器接收到长的 XML 文件后，DOM 解析可能会很复杂
			
	3. 数据格式为 JSON 的形式
		
		<1>. 优点：
		
			① 作为一种数据传输形式，JSON 与 XML 很相似，但是 JSON 更加灵巧
			② JSON 不需要从服务器端发送还有特定内容类型的首部信息
		
		<2>. 缺点：
		
			① 语法过于严谨
			② 代码不易读
			③ eval 函数存在风险
				举例：因为 eval 函数是将字符串转换为 js 代码来执行，如果字符串转换为 js 为恶意的无线循环，可能是浏览器卡死
			
	4. 三种数据格式的对比小结
	
		<1>. 若应用程序不需要与其他应用程序共享数据的时候，使用 html 片段来返回数据是最简单的
		
		<2>. 如果数据需要重用，JSON 文件是个不错的选择，其在性能和文件大小方面都有优势
		
		<3>. 当远程应用程序未知时，XML 是首选，因为 XML 是 WEB 服务领域的 "世界语"
