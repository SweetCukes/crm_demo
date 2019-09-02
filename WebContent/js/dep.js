 function formSumit(){ 
	 var formObj=document.getElementById("formId");
	 if(depBlur()){
		 formObj.submit();//手动提交表单
		 return true;
	 }
	 return false;
   }
   function depBlur(){
	  var lid= document.getElementById("depId");
	  var ltp= document.getElementById("depTip");
	  if(lid.value ==""){
		  ltp.innerHTML="请输入部门名！！";
		  return false;
	  }else{
		  return checkDepName(lid.value);
		  
		  //ltp.innerHTML="<em style='color:green'>√</em>";
	  }
	 return true;
   } 
   var xhr;  //javascript
   function checkDepName(depName){
	   var url = "checkDep.do?depName="+depName;
	   return doAjax(url);
   }
   function doAjax(url){
       try{//ie新版本的写法
          xhr = new ActiveXObject("Msxml2.XMLHTTP");
       }catch(e){
          try{ //老版本的ie
             xhr = new ActiveXObject("Microsoft.XMLHTTP");
	         }catch(e){
	            try{//火狐 谷歌 
	               xhr = new XMLHttpRequest();
	               if(xhr.overrideMimeType){
	                 xhr.overrideMimeType("text/xml");
	               }
	            }catch(e){
	               alert("无法创建XMLHttpRequest对象");
	               return false;
	            }
	         }//end catch2
       }//end catch1
       if(null==xhr){
         alert("XMLHttpRequest为空");
         return false;
       }
       //指定请求处理的回调函数 processRequest
       xhr.onreadystatechange = showMessage;
       //打开连接
       xhr.open("post", url, true);
       //如果是以post发送xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
       //发送请求
       xhr.send(null);//没有内容主体 就发null
     }    
     //处理请求返回的数据
     function showMessage(){
       var messdiv = document.getElementById("depTip");
       if(xhr.readyState==4){
         if(xhr.status==200){
           if(xhr.responseText=="false"){ 
              messdiv.innerHTML="<font style='color:green'>部门名可以使用！</font>";
           }else{
              messdiv.innerHTML="<font style='color:red'>部门名已被使用！</font>";
           }
         }else{
            alert("请求处理返回的数据有错误！");
         }
       }
     }