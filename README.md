# Ajax_summarize

## 有关ajax的用法及其应用的总结

### 1. 关于xmlhttprequest的readystate属性的五个状态

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
