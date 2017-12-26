<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>菜单列表</title>
    <jsp:include page="./../header.jsp"></jsp:include>
    <script type="text/javascript">
        $(document).ready(function(e) {
            $(".select1").uedSelect({
                width : 345
            });
            $(".select2").uedSelect({
                width : 167
            });
            $(".select3").uedSelect({
                width : 100
            });
        });
    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="javascript:top.location.reload();">首页</a></li>
        <li><a href="#">菜单列表</a></li>
    </ul>
</div>

<div class="formbody">
    <div id="usual1" class="usual">
            <ul class="seachform">
                <li><label>综合查询</label><input name="" type="text" class="scinput" /></li>
                <li><label>指派</label>
                    <div class="vocation">
                        <select class="select3">
                            <option>全部</option>
                            <option>其他</option>
                        </select>
                    </div>
                </li>
                <li><label>重点客户</label>
                    <div class="vocation">
                        <select class="select3">
                            <option>全部</option>
                            <option>其他</option>
                        </select>
                    </div>
                </li>
                <li><label>客户状态</label>
                    <div class="vocation">
                        <select class="select3">
                            <option>全部</option>
                            <option>其他</option>
                        </select>
                    </div>
                </li>
                <li><label>&nbsp;</label><input name="" type="button" class="scbtn" value="查询"/></li>
            </ul>
        <div class="tools">
            <ul class="toolbar">
                <li class="click"><span><img src="${staticUrl}/images/t01.png" /></span>添加</li>
                <li class="click"><span><img src="${staticUrl}/images/t02.png" /></span>修改</li>
                <li class="click"><span><img src="${staticUrl}/images/t03.png" /></span>删除</li>
            </ul>
            <ul class="toolbar1">
                <li class="click"><span><img src="${staticUrl}/images/t05.png" /></span>导出</li>
            </ul>

        </div>
            <table class="tablelist">
                <thead>
                <tr>
                    <th><input name="selectAll" type="checkbox" value="" checked="checked"/></th>
                    <th>编号</th>
                    <th>菜单编码</th>
                    <th>菜单名称</th>
                    <th>菜单类型</th>
                    <th>上级菜单编码</th>
                    <th>上级菜单名称</th>
                    <th>菜单URL</th>
                    <th>排序</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        <div class="pagin">
            <div class="message">共<i class="blue">1256</i>条记录，当前第&nbsp;<i class="blue">2&nbsp;</i>页</div>
            <ul class="paginList">
                <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
                <li class="paginItem current"><a href="javascript:;"><span class="pagerfh"></span></a></li>
                <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
            </ul>
        </div>
    </div>

    <script type="text/javascript">
        $("#usual1 ul").idTabs();
    </script>

    <script type="text/javascript">
        $('.tablelist tbody tr:odd').addClass('odd');
    </script>
</div>
</body>
</html>
