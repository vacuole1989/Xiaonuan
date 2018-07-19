<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<nav id="sidebar">
    <div class="sidebar-header" id="sidebarCollapse">
        <h3>无介时代</h3>
        <strong><img src="img/headimg.png" style="width: 40px;height: 40px;border-radius:20px; "></strong>
    </div>

    <ul class="list-unstyled components">
        <li>
            <a href="#">
                <i><img src="${loginUser.avatarUrl}" style="width: 30px;height: 30px;border-radius:15px; "></i>
                ${loginUser.nickName}
            </a>
        </li>
        <li>
            <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="true" class="collapsed">
                <i class="glyphicon glyphicon-duplicate"></i>
                日常管理
            </a>
            <ul class="collapse list-unstyled in" id="pageSubmenu">
                <li><a onclick="jump('chat')">聊天记录</a></li>
                <li><a onclick="jump('gift')">礼物信息</a></li>
                <li><a onclick="jump('pay')">缴费管理</a></li>
                <li><a onclick="jump('skill')">技能信息</a></li>
                <li><a onclick="jump('config')">系统信息</a></li>
                <li><a onclick="jump('user')">用户管理</a></li>
            </ul>
        </li>
        <li>
            <a onclick="loginout()">
                <i class="glyphicon glyphicon-log-out"></i>
                退出
            </a>
        </li>
    </ul>
</nav>
<script type="text/javascript">
    $(document).ready(function () {
        $('#sidebarCollapse').on('click', function () {
            if ('active' == $('#sidebar').attr('class')) {
                setCookie('tab', '', 365);
            } else {
                setCookie('tab', 'active', 365);
            }
            $('#sidebar').toggleClass('active');
        });
        var tab = null;
        var name = "tab=";
        var ca = document.cookie.split(';');
        for (var i = 0; i < ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) == ' ') {
                c = c.substring(1)
            }
            if (c.indexOf(name) != -1) {
                tab = c.substring(name.length, c.length)
            }
        }
        if (tab == 'active') {
            $('#sidebar').attr('class', 'active');
        } else {
            $('#sidebar').attr('class', '');
        }

    });

    function jump(tag) {
        location.href = './index?tag=' + tag;
    }

    function loginout() {
        layer.confirm('是否退出无介时代', function () {
            location.href = './loginout';
        });

    }

    function setCookie(c_name, value, expiredays) {
        var exdate = new Date()
        exdate.setDate(exdate.getDate() + expiredays)
        document.cookie = c_name + "=" + escape(value) +
            ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString())
    }

</script>