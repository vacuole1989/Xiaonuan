<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div style="position: absolute;">
    每页显示
    <select style="width: 45px;height: 30px;display: inline-block;padding: 0;" v-model="param.pageSize" class="form-control">
        <option value="10">10</option>
        <option value="20">20</option>
        <option value="50">50</option>
        <option value="100">100</option>
    </select>
    条记录
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    当前第{{param.page}}页，共{{pageNum}}页。共{{totalCount}}条记录

</div>
<nav aria-label="" style="text-align: right;" >
    <ul class="pagination" style="margin: 0;">
        <li :class="{'disabled':param.page==1?true:false}"><a aria-label="Previous" @click="prev()" style="cursor: pointer"><span aria-hidden="true">上一页</span></a>
        </li>
        <li :class="{'disabled':param.page>=pageNum?true:false}"><a aria-label="Next" @click="next()" style="cursor: pointer"><span aria-hidden="true">下一页</span></a></li>
    </ul>
</nav>