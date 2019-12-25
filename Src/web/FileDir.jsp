<!DOCTYPE html>
<%@page pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/Extern/jquery-3.4.1.min.js"></script>
    <style>
        .icon{
            width:100px;
            height: 80px;
        }
        li{
            list-style-type: none;
            float: left;
        }
        #mainfram{
            margin: 100px auto;
            width:500px;
            height: 500px;
            border: 1px solid burlywood;
        }

        .dir{
            margin-top: 10px;
            padding-left: 1%;
            width: 120px;
            height: 110px;
            border: white 2px solid;

        }
        .dir:hover{
            border: darkred 2px solid;
        }
        .dir_name{
            margin: 5px auto;
            font-size: 14px;
            line-height: 15px;
            height: 15px;
            text-align: center;
        }
        #goBackBtn{
            width: 55px;
            height: 45px;
            border: 1px solid goldenrod;
            position: fixed;
            left:420px;
            top:150px;
        }
        #goBackBtn:hover{
            border: 2px solid black;
        }
    </style>

</head>
<body>
<% String File_icon=request.getContextPath()+"/file.JPG" ;%>
<h1 align="center">Files</h1>
<div id="goBackBtn" onclick="newM()" >上一级</div>
<div id="mainfram" name="test">
    <ul>

    </ul>
</div>

<script>

    newM();

    function newM() {
        //画 目录 得核心代码
        $.ajax({
            url: "${pageContext.request.contextPath}"+"/test.json",//json文件位置
            type: "GET",//请求方式为get
            dataType: "json", //返回数据格式为json
            success: function (data) {//请求成功完成后要执行的方法
                //each循环 使用$.each方法遍历返回的数据date
                $.each(data, function (id, file) {
                    // var str=dir["name"]

                    var str;

                    if (file["type"] == "dir") {
                        // File_icon为文件夹图片的地址
                        str = '<li class="dir" ><img src=<%=File_icon%>  alt="123" class="icon"><div class="dir_name">'
                            + file["name"] + '</div></li>';
                    }
                    else if(file["type"]=="img"){
                        str='<li class="dir" ><img src='+'<%=request.getContextPath()%>'+file["src"]+' alt="123" class="icon"><div class="dir_name">'
                            +'</div></li>';
                    }
                    $("ul").append(str);
                })
            }
        })
    }






    <%--function enterInto(address,name) {--%>
    <%--    $("ul").empty();--%>
    <%--    // name="123";--%>
    <%--    &lt;%&ndash;alert('<%=request.getContextPath()%>'+address+'/'+name+".json");&ndash;%&gt;--%>

    <%--    $.ajax(--%>
    <%--        {--%>
    <%--            url : '<%=request.getContextPath()%>'+address+'/'+name+".json",--%>
    <%--            type: "GET",//请求方式为get--%>
    <%--            dataType: "json", //返回数据格式为json--%>
    <%--            success: function (data) {--%>
    <%--                $.each(data.Files, function (id,file) {--%>
    <%--                    var str;--%>
    <%--                    if(file["type"]=="img"){--%>
    <%--                        str='<li class="dir" ><img src='+'<%=request.getContextPath()%>'+file["src"]+' alt="123" class="icon"><div class="dir_name">'--%>
    <%--                            +'</div></li>';--%>
    <%--                        // alert(str);--%>
    <%--                    }--%>

    <%--                    else if(file["type"] == "dir") {--%>
    <%--                        str = '<li class="dir" ondblclick="enterInto('+'\''+address+"/"+file["name"]+'\',\''+file["name"]+'\') "><img src=<%=File_icon%>  alt="123" class="icon"><div class="dir_name">'--%>
    <%--                            + file["name"] + '</div></li>';--%>
    <%--                    }--%>
    <%--                    $("ul").append(str);--%>
    <%--                })--%>
    <%--            }--%>
    <%--        }--%>
    <%--    )--%>

    <%--}--%>
</script>
</body>
</html>