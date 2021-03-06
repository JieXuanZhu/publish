<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/general_path.jsp"%>
<!doctype>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-widht,minimun-scale=1.0,maximun-scale=1.0,user-scalable=no,initial-scale=1.0" >
		<title>创建数据来源</title>
		<%@include file="/WEB-INF/views/admin/include_css.jsp" %>
	</head>
	<body>
		<div id="slider_content" class="content">
			<div class="content_div">
				<h1>
					<span class="action-span"><a href="javascript:void(0);" onclick="history.go(-1);">返回</a></span>
					<span class="action-span1">管理中心</span>
					<span class="action-span1 action-span2">-创建数据源</span>
				</h1>
				<form id="id_source_form_id" action="<%=path %>/admin/data/addNewInfoCrawlConfig" method="post">
					<input type="hidden" name="springMVC.token" value="${TOKEN}">
					<input type="hidden" name="id" id="id_src_id" value="${source.id }">
				<div class="main-div">
				<fieldset>
					<legend>数据源配置</legend>
					<table>
							<tr>
								<td class="label">抓取网站名称：</td>
								<td><input id="siteName" name="siteName"  type="text" value="${source.siteName }" class="input" /><span class="require-field">*</span></td>
							</tr>
							<tr>
								<td class="label">抓取网站地址：</td>
								<td><input id="siteUrl" name="siteUrl"  type="text" value="${source.siteUrl }" class="input" /><span class="require-field">*</span></td>
							</tr>
							<tr>
								<td class="label">抓取网站开始地址：</td>
								<td><input id="startUrl" name="startUrl"  type="text" value="${source.startUrl }" class="input" /><span class="require-field">*</span></td>
							</tr>
							<tr>
							
								<td class="label">抓取开始页数</td>
								<td>
								<input id="pageNumReg" name="resv4"  type="text" value="${source.resv4 }" class="input" /><span class="require-field">*使用"$\{pagenum \}"代替分页参数</span>
								<input id="startPageNum" name="resv2"  type="text" value="${source.resv2 }" class="input" /><span class="require-field">*</span>
								<input id="endPageNum" name="resv3"  type="text" value="${source.resv3 }" class="input" /><span class="require-field">*</span>
								</td>
							</tr>
							<%-- <tr>
								<td class="label">是否替换附件链接：</td>
								<td><input name="resv1" value="0" type="radio" <c:if test="${source.resv1=='0' }">checked="checked"</c:if>>是 &nbsp;&nbsp;&nbsp;
									<input name="resv1" value="1" type="radio" <c:if test="${source.resv1=='1' }">checked="checked"</c:if>>否
								<span class="require-field">如果选择替换附件链接，那么在抓取的时候，会下载附件，并将抓取附件内容的链接替换为本地链接</span></td>
							</tr> --%>
							<tr>
								<td class="label">网站分类：</td>
								<td>
									<select name="siteType">
										<option value="资讯类" <c:if test="${source.siteType=='资讯类' }">selected="selected"</c:if>>资讯类</option>
										<option value="政策类" <c:if test="${source.siteType=='政策类' }">selected="selected"</c:if>>政策类</option>
										<option value="告示类" <c:if test="${source.siteType=='告示类' }">selected="selected"</c:if>>告示类</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="label">展示类别</td>
								<td>
									<select name="labelId">
										<option value="">--选择抓取资讯展示类别</option>
										<c:forEach items="${labelList }" var="label" varStatus="labelStatus">
											<option value="${label.id }" <c:if test="${source.labelId==label.id }">selected="selected"</c:if>>${label.label_name } </option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td class="label">是否处理文本：</td>
								<td><input name="isWrapB" value="0" type="radio" <c:if test="${source.isWrapB=='0' }">checked="checked"</c:if>>是 &nbsp;&nbsp;&nbsp;<input name="isWrapB" value="1" type="radio" <c:if test="${source.isWrapB=='1' }">checked="checked"</c:if>>否
								<span class="require-field">如果选择处理文本，那么会在页面的文本部分加上"b"标签包围文本内容</span></td>
							</tr>
							<%-- <tr>
								<td class="label">抓取开始时间：</td>
								<td><input id="crawlBeginTime" name="crawlBeginTime"  type="text" value="<fmt:formatDate value="${source.crawlBeginTime }" pattern="yyyy-MM-dd"/>" class="input Wdate" onfocus="WdatePicker({lang:'zh-cn'});" /></td>
							</tr>
							<tr>
								<td class="label">抓取结束时间：</td>
								<td><input id="crawlEndTime" name="crawlEndTime"  type="text" value="<fmt:formatDate value="${source.crawlEndTime }" pattern="yyyy-MM-dd"/>" class="input Wdate" onfocus="WdatePicker({lang:'zh-cn'});" /></td>
							</tr> --%>
						</table>
				</fieldset>
				<fieldset>
					<legend>抓取字段配置</legend>
					<table>
						<thead>
							<tr>
								<th>抓取字段</th>
								<th>保存字段</th>
								<th>选择器</th>
								<th>备用选择器</th>
								<th>截取正则表达式</th>
								<th>是否保留HTML标签</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="label">标题：<input type="hidden" name="infoConfigs[0].id" value="${source.infoConfigs[1].id }"></td>
								<td><select name="infoConfigs[0].prop">
									<option value="">--请选择字段名称--</option>
									<c:forEach items="${tableInfos }" var="tableInfo" varStatus="tableInfoStatus">
										<option value="${tableInfo.name}" <c:if test="${source.infoConfigs[0].prop == tableInfo.name }">selected="selected"</c:if>>${tableInfo.name }</option>
									</c:forEach>
								</select></td>
								<td>
									<input id="id_title_selector_id" name="infoConfigs[0].selector"  type="text" value="${source.infoConfigs[0].selector }" class="input" />
								</td>
								<td>
									<input id="id_title_orselector_id" name="infoConfigs[0].orSelector"  type="text" value="${source.infoConfigs[0].orSelector }" class="input" />
								</td>
								<td>
									<input id="id_title_subreg_id" name="infoConfigs[0].subReg"  type="text" value="${source.infoConfigs[0].subReg }" class="input" />
								</td>
								<td>
									<input name="infoConfigs[0].isResvHtml" value="0" type="radio" <c:if test="${source.infoConfigs[0].isResvHtml=='0' }">checked="checked"</c:if>>是 &nbsp;&nbsp;&nbsp;
									<input name="infoConfigs[0].isResvHtml" value="1" type="radio" <c:if test="${source.infoConfigs[0].isResvHtml=='1' }">checked="checked"</c:if>>否
								</td>
							</tr>
							<tr>
								<td class="label">副标题：<input type="hidden" name="infoConfigs[1].id" value="${source.infoConfigs[1].id }"></td>
								<td><select name="infoConfigs[1].prop">
									<option value="">--请选择字段名称--</option>
									<c:forEach items="${tableInfos }" var="tableInfo" varStatus="tableInfoStatus">
										<option value="${tableInfo.name}" <c:if test="${source.infoConfigs[1].prop == tableInfo.name }">selected="selected"</c:if>>${tableInfo.name }</option>
									</c:forEach>
								</select></td>
								<td>
									<input id="id_title_selector_id" name="infoConfigs[1].selector"  type="text" value="${source.infoConfigs[1].selector }" class="input" />
								</td>
								<td>
									<input id="id_title_orselector_id" name="infoConfigs[1].orSelector"  type="text" value="${source.infoConfigs[1].orSelector }" class="input" />
								</td>
								<td>
									<input id="id_title_subreg_id" name="infoConfigs[1].subReg"  type="text" value="${source.infoConfigs[1].subReg }" class="input" />
								</td>
								<td>
									<input name="infoConfigs[1].isResvHtml" value="0" type="radio" <c:if test="${source.infoConfigs[1].isResvHtml=='0' }">checked="checked"</c:if>>是 &nbsp;&nbsp;&nbsp;
									<input name="infoConfigs[1].isResvHtml" value="1" type="radio" <c:if test="${source.infoConfigs[1].isResvHtml=='1' }">checked="checked"</c:if>>否
								</td>
							</tr>
							<tr>
								<td class="label">发表时间：<input type="hidden" name="infoConfigs[2].id" value="${source.infoConfigs[2].id }"></td>
								<td><select name="infoConfigs[2].prop">
									<option value="">--请选择字段名称--</option>
									<c:forEach items="${tableInfos }" var="tableInfo" varStatus="tableInfoStatus">
										<option value="${tableInfo.name}" <c:if test="${source.infoConfigs[2].prop == tableInfo.name }">selected="selected"</c:if>>${tableInfo.name }</option>
									</c:forEach>
								</select></td>
								<td>
									<input id="id_title_selector_id" name="infoConfigs[2].selector"  type="text" value="${source.infoConfigs[2].selector }" class="input" />
								</td>
								<td>
									<input id="id_title_orselector_id" name="infoConfigs[2].orSelector"  type="text" value="${source.infoConfigs[2].orSelector }" class="input" />
								</td>
								<td>
									<input id="id_title_subreg_id" name="infoConfigs[2].subReg"  type="text" value="${source.infoConfigs[2].subReg }" class="input" />
								</td>
								<td>
									<input name="infoConfigs[2].isResvHtml" value="0" type="radio" <c:if test="${source.infoConfigs[2].isResvHtml=='0' }">checked="checked"</c:if>>是 &nbsp;&nbsp;&nbsp;
									<input name="infoConfigs[2].isResvHtml" value="1" type="radio" <c:if test="${source.infoConfigs[2].isResvHtml=='1' }">checked="checked"</c:if>>否
								</td>
							</tr>
							<tr>
								<td class="label">作者：<input type="hidden" name="infoConfigs[3].id" value="${source.infoConfigs[3].id }"></td>
								<td><select name="infoConfigs[3].prop">
									<option value="">--请选择字段名称--</option>
									<c:forEach items="${tableInfos }" var="tableInfo" varStatus="tableInfoStatus">
										<option value="${tableInfo.name}" <c:if test="${source.infoConfigs[3].prop == tableInfo.name }">selected="selected"</c:if>>${tableInfo.name }</option>
									</c:forEach>
								</select></td>
								<td>
									<input id="id_title_selector_id" name="infoConfigs[3].selector"  type="text" value="${source.infoConfigs[3].selector }" class="input" />
								</td>
								<td>
									<input id="id_title_orselector_id" name="infoConfigs[3].orSelector"  type="text" value="${source.infoConfigs[3].orSelector }" class="input" />
								</td>
								<td>
									<input id="id_title_subreg_id" name="infoConfigs[3].subReg"  type="text" value="${source.infoConfigs[3].subReg }" class="input" />
								</td>
								<td>
									<input name="infoConfigs[3].isResvHtml" value="0" type="radio" <c:if test="${source.infoConfigs[3].isResvHtml=='0' }">checked="checked"</c:if>>是 &nbsp;&nbsp;&nbsp;
									<input name="infoConfigs[3].isResvHtml" value="1" type="radio" <c:if test="${source.infoConfigs[3].isResvHtml=='1' }">checked="checked"</c:if>>否
								</td>
							</tr>
							<tr>
								<td class="label">新闻类别：<input type="hidden" name="infoConfigs[4].id" value="${source.infoConfigs[4].id }"></td>
								<td><select name="infoConfigs[4].prop">
									<option value="">--请选择字段名称--</option>
									<c:forEach items="${tableInfos }" var="tableInfo" varStatus="tableInfoStatus">
										<option value="${tableInfo.name}" <c:if test="${source.infoConfigs[4].prop == tableInfo.name }">selected="selected"</c:if>>${tableInfo.name }</option>
									</c:forEach>
								</select></td>
								<td>
									<input id="id_title_selector_id" name="infoConfigs[4].selector"  type="text" value="${source.infoConfigs[4].selector }" class="input" />
								</td>
								<td>
									<input id="id_title_orselector_id" name="infoConfigs[4].orSelector"  type="text" value="${source.infoConfigs[4].orSelector }" class="input" />
								</td>
								<td>
									<input id="id_title_subreg_id" name="infoConfigs[4].subReg"  type="text" value="${source.infoConfigs[4].subReg }" class="input" />
								</td>
								<td>
									<input name="infoConfigs[4].isResvHtml" value="0" type="radio" <c:if test="${source.infoConfigs[4].isResvHtml=='0' }">checked="checked"</c:if>>是 &nbsp;&nbsp;&nbsp;
									<input name="infoConfigs[4].isResvHtml" value="1" type="radio" <c:if test="${source.infoConfigs[4].isResvHtml=='1' }">checked="checked"</c:if>>否
								</td>
							</tr>
							<tr>
								<td class="label">内容：<input type="hidden" name="infoConfigs[5].id" value="${source.infoConfigs[5].id }"></td>
								<td><select name="infoConfigs[5].prop">
									<option value="">--请选择字段名称--</option>
									<c:forEach items="${tableInfos }" var="tableInfo" varStatus="tableInfoStatus">
										<option value="${tableInfo.name}" <c:if test="${source.infoConfigs[5].prop == tableInfo.name }">selected="selected"</c:if>>${tableInfo.name }</option>
									</c:forEach>
								</select></td>
								<td>
									<input id="id_title_selector_id" name="infoConfigs[5].selector"  type="text" value="${source.infoConfigs[5].selector }" class="input" />
								</td>
								<td>
									<input id="id_title_orselector_id" name="infoConfigs[5].orSelector"  type="text" value="${source.infoConfigs[5].orSelector }" class="input" />
								</td>
								<td>
									<input id="id_title_subreg_id" name="infoConfigs[5].subReg"  type="text" value="${source.infoConfigs[5].subReg }" class="input" />
								</td>
								<td>
									<input name="infoConfigs[5].isResvHtml" value="0" type="radio" <c:if test="${source.infoConfigs[5].isResvHtml=='0' }">checked="checked"</c:if>>是 &nbsp;&nbsp;&nbsp;
									<input name="infoConfigs[5].isResvHtml" value="1" type="radio" <c:if test="${source.infoConfigs[5].isResvHtml=='1' }">checked="checked"</c:if>>否
								</td>
							</tr>
							<tr>
								<td class="label">附件：<input type="hidden" name="infoConfigs[6].id" value="${source.infoConfigs[6].id }"></td>
								<td><select name="infoConfigs[6].prop">
									<option value="">--请选择字段名称--</option>
									<c:forEach items="${tableInfos }" var="tableInfo" varStatus="tableInfoStatus">
										<option value="${tableInfo.name}" <c:if test="${source.infoConfigs[6].prop == tableInfo.name }">selected="selected"</c:if>>${tableInfo.name }</option>
									</c:forEach>
								</select></td>
								<td>
									<input id="id_title_selector_id" name="infoConfigs[6].selector"  type="text" value="${source.infoConfigs[6].selector }" class="input" />
								</td>
								<td>
									<input id="id_title_orselector_id" name="infoConfigs[6].orSelector"  type="text" value="${source.infoConfigs[6].orSelector }" class="input" />
								</td>
								<td>
									<input id="id_title_subreg_id" name="infoConfigs[6].subReg"  type="text" value="${source.infoConfigs[6].subReg }" class="input" />
								</td>
								<td>
									<input name="infoConfigs[6].isResvHtml" value="0" type="radio" <c:if test="${source.infoConfigs[6].isResvHtml=='0' }">checked="checked"</c:if>>是 &nbsp;&nbsp;&nbsp;
									<input name="infoConfigs[6].isResvHtml" value="1" type="radio" <c:if test="${source.infoConfigs[6].isResvHtml=='1' }">checked="checked"</c:if>>否
								</td>
							</tr>
							<tr>
								<td class="label">浏览次数：<input type="hidden" name="infoConfigs[7].id" value="${source.infoConfigs[7].id }"></td>
								<td><select name="infoConfigs[7].prop">
									<option value="">--请选择字段名称--</option>
									<c:forEach items="${tableInfos }" var="tableInfo" varStatus="tableInfoStatus">
										<option value="${tableInfo.name}" <c:if test="${source.infoConfigs[7].prop == tableInfo.name }">selected="selected"</c:if>>${tableInfo.name }</option>
									</c:forEach>
								</select></td>
								<td>
									<input id="id_title_selector_id" name="infoConfigs[7].selector"  type="text" value="${source.infoConfigs[7].selector }" class="input" />
								</td>
								<td>
									<input id="id_title_orselector_id" name="infoConfigs[7].orSelector"  type="text" value="${source.infoConfigs[7].orSelector }" class="input" />
								</td>
								<td>
									<input id="id_title_subreg_id" name="infoConfigs[7].subReg"  type="text" value="${source.infoConfigs[7].subReg }" class="input" />
								</td>
								<td>
									<input name="infoConfigs[7].isResvHtml" value="0" type="radio" <c:if test="${source.infoConfigs[7].isResvHtml=='0' }">checked="checked"</c:if>>是 &nbsp;&nbsp;&nbsp;
									<input name="infoConfigs[7].isResvHtml" value="1" type="radio" <c:if test="${source.infoConfigs[7].isResvHtml=='1' }">checked="checked"</c:if>>否
								</td>
							</tr>
							<tr>
								<td class="label">新闻来源：<input type="hidden" name="infoConfigs[8].id" value="${source.infoConfigs[8].id }"></td>
								<td><select name="infoConfigs[8].prop">
									<option value="">--请选择字段名称--</option>
									<c:forEach items="${tableInfos }" var="tableInfo" varStatus="tableInfoStatus">
										<option value="${tableInfo.name}" <c:if test="${source.infoConfigs[8].prop == tableInfo.name }">selected="selected"</c:if>>${tableInfo.name }</option>
									</c:forEach>
								</select></td>
								<td>
									<input id="id_title_selector_id" name="infoConfigs[8].selector"  type="text" value="${source.infoConfigs[8].selector }" class="input" />
								</td>
								<td>
									<input id="id_title_orselector_id" name="infoConfigs[8].orSelector"  type="text" value="${source.infoConfigs[8].orSelector }" class="input" />
								</td>
								<td>
									<input id="id_title_subreg_id" name="infoConfigs[8].subReg"  type="text" value="${source.infoConfigs[8].subReg }" class="input" />
								</td>
								<td>
									<input name="infoConfigs[8].isResvHtml" value="0" type="radio" <c:if test="${source.infoConfigs[8].isResvHtml=='0' }">checked="checked"</c:if>>是 &nbsp;&nbsp;&nbsp;
									<input name="infoConfigs[8].isResvHtml" value="1" type="radio" <c:if test="${source.infoConfigs[8].isResvHtml=='1' }">checked="checked"</c:if>>否
								</td>
							</tr>
							<%-- <tr>
								<td class="label">抓取来源：</td>
								<td><input id="category_name" name="category_name"  type="text" value="${dataCategory.category_name }" class="input" /><span class="require-field">*</span></td>
							</tr> --%>
							<tr>
								<td class="label">索引号：<input type="hidden" name="infoConfigs[9].id" value="${source.infoConfigs[9].id }"></td>
								<td><select name="infoConfigs[9].prop">
									<option value="">--请选择字段名称--</option>
									<c:forEach items="${tableInfos }" var="tableInfo" varStatus="tableInfoStatus">
										<option value="${tableInfo.name}" <c:if test="${source.infoConfigs[9].prop == tableInfo.name }">selected="selected"</c:if>>${tableInfo.name }</option>
									</c:forEach>
								</select></td>
								<td>
									<input id="id_title_selector_id" name="infoConfigs[9].selector"  type="text" value="${source.infoConfigs[9].selector }" class="input" />
								</td>
								<td>
									<input id="id_title_orselector_id" name="infoConfigs[9].orSelector"  type="text" value="${source.infoConfigs[9].orSelector }" class="input" />
								</td>
								<td>
									<input id="id_title_subreg_id" name="infoConfigs[9].subReg"  type="text" value="${source.infoConfigs[9].subReg }" class="input" />
								</td>
								<td>
									<input name="infoConfigs[9].isResvHtml" value="0" type="radio" <c:if test="${source.infoConfigs[9].isResvHtml=='0' }">checked="checked"</c:if>>是 &nbsp;&nbsp;&nbsp;
									<input name="infoConfigs[9].isResvHtml" value="1" type="radio" <c:if test="${source.infoConfigs[9].isResvHtml=='1' }">checked="checked"</c:if>>否
								</td>
							</tr>
							<tr>
								<td class="label">主题分类：<input type="hidden" name="infoConfigs[10].id" value="${source.infoConfigs[10].id }"></td>
								<td><select name="infoConfigs[10].prop">
									<option value="">--请选择字段名称--</option>
									<c:forEach items="${tableInfos }" var="tableInfo" varStatus="tableInfoStatus">
										<option value="${tableInfo.name}" <c:if test="${source.infoConfigs[10].prop == tableInfo.name }">selected="selected"</c:if>>${tableInfo.name }</option>
									</c:forEach>
								</select></td>
								<td>
									<input id="id_title_selector_id" name="infoConfigs[10].selector"  type="text" value="${source.infoConfigs[10].selector }" class="input" />
								</td>
								<td>
									<input id="id_title_orselector_id" name="infoConfigs[10].orSelector"  type="text" value="${source.infoConfigs[10].orSelector }" class="input" />
								</td>
								<td>
									<input id="id_title_subreg_id" name="infoConfigs[10].subReg"  type="text" value="${source.infoConfigs[10].subReg }" class="input" />
								</td>
								<td>
									<input name="infoConfigs[10].isResvHtml" value="0" type="radio" <c:if test="${source.infoConfigs[10].isResvHtml=='0' }">checked="checked"</c:if>>是 &nbsp;&nbsp;&nbsp;
									<input name="infoConfigs[10].isResvHtml" value="1" type="radio" <c:if test="${source.infoConfigs[10].isResvHtml=='1' }">checked="checked"</c:if>>否
								</td>
							</tr>
							<tr>
								<td class="label">发布机关：<input type="hidden" name="infoConfigs[11].id" value="${source.infoConfigs[11].id }"></td>
								<td><select name="infoConfigs[11].prop">
									<option value="">--请选择字段名称--</option>
									<c:forEach items="${tableInfos }" var="tableInfo" varStatus="tableInfoStatus">
										<option value="${tableInfo.name}" <c:if test="${source.infoConfigs[11].prop == tableInfo.name }">selected="selected"</c:if>>${tableInfo.name }</option>
									</c:forEach>
								</select></td>
								<td>
									<input id="id_title_selector_id" name="infoConfigs[11].selector"  type="text" value="${source.infoConfigs[11].selector }" class="input" />
								</td>
								<td>
									<input id="id_title_orselector_id" name="infoConfigs[11].orSelector"  type="text" value="${source.infoConfigs[11].orSelector }" class="input" />
								</td>
								<td>
									<input id="id_title_subreg_id" name="infoConfigs[11].subReg"  type="text" value="${source.infoConfigs[11].subReg }" class="input" />
								</td>
								<td>
									<input name="infoConfigs[11].isResvHtml" value="0" type="radio" <c:if test="${source.infoConfigs[11].isResvHtml=='0' }">checked="checked"</c:if>>是 &nbsp;&nbsp;&nbsp;
									<input name="infoConfigs[11].isResvHtml" value="1" type="radio" <c:if test="${source.infoConfigs[11].isResvHtml=='1' }">checked="checked"</c:if>>否
								</td>
							</tr>
							<tr>
								<td class="label">发布日期：<input type="hidden" name="infoConfigs[12].id" value="${source.infoConfigs[12].id }"></td>
								<td><select name="infoConfigs[12].prop">
									<option value="">--请选择字段名称--</option>
									<c:forEach items="${tableInfos }" var="tableInfo" varStatus="tableInfoStatus">
										<option value="${tableInfo.name}" <c:if test="${source.infoConfigs[12].prop == tableInfo.name }">selected="selected"</c:if>>${tableInfo.name }</option>
									</c:forEach>
								</select></td>
								<td>
									<input id="id_title_selector_id" name="infoConfigs[12].selector"  type="text" value="${source.infoConfigs[12].selector }" class="input" />
								</td>
								<td>
									<input id="id_title_orselector_id" name="infoConfigs[12].orSelector"  type="text" value="${source.infoConfigs[12].orSelector }" class="input" />
								</td>
								<td>
									<input id="id_title_subreg_id" name="infoConfigs[12].subReg"  type="text" value="${source.infoConfigs[12].subReg }" class="input" />
								</td>
								<td>
									<input name="infoConfigs[12].isResvHtml" value="0" type="radio" <c:if test="${source.infoConfigs[12].isResvHtml=='0' }">checked="checked"</c:if>>是 &nbsp;&nbsp;&nbsp;
									<input name="infoConfigs[12].isResvHtml" value="1" type="radio" <c:if test="${source.infoConfigs[12].isResvHtml=='1' }">checked="checked"</c:if>>否
								</td>
							</tr>
						<tr>
							<td class="label">名称：<input type="hidden" name="infoConfigs[13].id" value="${source.infoConfigs[13].id }"></td>
							<td><select name="infoConfigs[13].prop">
									<option value="">--请选择字段名称--</option>
									<c:forEach items="${tableInfos }" var="tableInfo" varStatus="tableInfoStatus">
										<option value="${tableInfo.name}" <c:if test="${source.infoConfigs[13].prop == tableInfo.name }">selected="selected"</c:if>>${tableInfo.name }</option>
									</c:forEach>
								</select></td>
								<td>
									<input id="id_title_selector_id" name="infoConfigs[13].selector"  type="text" value="${source.infoConfigs[13].selector }" class="input" />
								</td>
								<td>
									<input id="id_title_orselector_id" name="infoConfigs[13].orSelector"  type="text" value="${source.infoConfigs[13].orSelector }" class="input" />
								</td>
								<td>
									<input id="id_title_subreg_id" name="infoConfigs[13].subReg"  type="text" value="${source.infoConfigs[13].subReg }" class="input" />
								</td>
								<td>
									<input name="infoConfigs[13].isResvHtml" value="0" type="radio" <c:if test="${source.infoConfigs[13].isResvHtml=='0' }">checked="checked"</c:if>>是 &nbsp;&nbsp;&nbsp;
									<input name="infoConfigs[13].isResvHtml" value="1" type="radio" <c:if test="${source.infoConfigs[13].isResvHtml=='1' }">checked="checked"</c:if>>否
								</td>
						</tr>
						<tr>
							<td class="label">主题词：<input type="hidden" name="infoConfigs[14].id" value="${source.infoConfigs[14].id }"></td>
							<td><select name="infoConfigs[14].prop">
									<option value="">--请选择字段名称--</option>
									<c:forEach items="${tableInfos }" var="tableInfo" varStatus="tableInfoStatus">
										<option value="${tableInfo.name}" <c:if test="${source.infoConfigs[14].prop == tableInfo.name }">selected="selected"</c:if>>${tableInfo.name }</option>
									</c:forEach>
								</select></td>
								<td>
									<input id="id_title_selector_id" name="infoConfigs[14].selector"  type="text" value="${source.infoConfigs[14].selector }" class="input" />
								</td>
								<td>
									<input id="id_title_orselector_id" name="infoConfigs[14].orSelector"  type="text" value="${source.infoConfigs[14].orSelector }" class="input" />
								</td>
								<td>
									<input id="id_title_subreg_id" name="infoConfigs[14].subReg"  type="text" value="${source.infoConfigs[14].subReg }" class="input" />
								</td>
								<td>
									<input name="infoConfigs[14].isResvHtml" value="0" type="radio" <c:if test="${source.infoConfigs[14].isResvHtml=='0' }">checked="checked"</c:if>>是 &nbsp;&nbsp;&nbsp;
									<input name="infoConfigs[14].isResvHtml" value="1" type="radio" <c:if test="${source.infoConfigs[14].isResvHtml=='1' }">checked="checked"</c:if>>否
								</td>
						</tr>
						<tr>
							<td class="label">文号：<input type="hidden" name="infoConfigs[15].id" value="${source.infoConfigs[15].id }"></td>
							<td><select name="infoConfigs[15].prop">
									<option value="">--请选择字段名称--</option>
									<c:forEach items="${tableInfos }" var="tableInfo" varStatus="tableInfoStatus">
										<option value="${tableInfo.name}" <c:if test="${source.infoConfigs[15].prop == tableInfo.name }">selected="selected"</c:if>>${tableInfo.name }</option>
									</c:forEach>
								</select></td>
								<td>
									<input id="id_title_selector_id" name="infoConfigs[15].selector"  type="text" value="${source.infoConfigs[15].selector }" class="input" />
								</td>
								<td>
									<input id="id_title_orselector_id" name="infoConfigs[15].orSelector"  type="text" value="${source.infoConfigs[15].orSelector }" class="input" />
								</td>
								<td>
									<input id="id_title_subreg_id" name="infoConfigs[15].subReg"  type="text" value="${source.infoConfigs[15].subReg }" class="input" />
								</td>
								<td>
									<input name="infoConfigs[15].isResvHtml" value="0" type="radio" <c:if test="${source.infoConfigs[15].isResvHtml=='0' }">checked="checked"</c:if>>是 &nbsp;&nbsp;&nbsp;
									<input name="infoConfigs[15].isResvHtml" value="1" type="radio" <c:if test="${source.infoConfigs[15].isResvHtml=='1' }">checked="checked"</c:if>>否
								</td>
						</tr>
						<tr>
							<td class="label">来文单位：<input type="hidden" name="infoConfigs[16].id" value="${source.infoConfigs[16].id }"></td>
							<td><select name="infoConfigs[16].prop">
									<option value="">--请选择字段名称--</option>
									<c:forEach items="${tableInfos }" var="tableInfo" varStatus="tableInfoStatus">
										<option value="${tableInfo.name}" <c:if test="${source.infoConfigs[16].prop == tableInfo.name }">selected="selected"</c:if>>${tableInfo.name }</option>
									</c:forEach>
								</select></td>
								<td>
									<input id="id_title_selector_id" name="infoConfigs[16].selector"  type="text" value="${source.infoConfigs[16].selector }" class="input" />
								</td>
								<td>
									<input id="id_title_orselector_id" name="infoConfigs[16].orSelector"  type="text" value="${source.infoConfigs[16].orSelector }" class="input" />
								</td>
								<td>
									<input id="id_title_subreg_id" name="infoConfigs[16].subReg"  type="text" value="${source.infoConfigs[16].subReg }" class="input" />
								</td>
								<td>
									<input name="infoConfigs[16].isResvHtml" value="0" type="radio" <c:if test="${source.infoConfigs[16].isResvHtml=='0' }">checked="checked"</c:if>>是 &nbsp;&nbsp;&nbsp;
									<input name="infoConfigs[16].isResvHtml" value="1" type="radio" <c:if test="${source.infoConfigs[16].isResvHtml=='1' }">checked="checked"</c:if>>否
								</td>
						</tr>
						<tr>
							<td class="label">审批文件名称：<input type="hidden" name="infoConfigs[17].id" value="${source.infoConfigs[17].id }"></td>
							<td><select name="infoConfigs[17].prop">
									<option value="">--请选择字段名称--</option>
									<c:forEach items="${tableInfos }" var="tableInfo" varStatus="tableInfoStatus">
										<option value="${tableInfo.name}" <c:if test="${source.infoConfigs[17].prop == tableInfo.name }">selected="selected"</c:if>>${tableInfo.name }</option>
									</c:forEach>
								</select></td>
								<td>
									<input id="id_title_selector_id" name="infoConfigs[17].selector"  type="text" value="${source.infoConfigs[17].selector }" class="input" />
								</td>
								<td>
									<input id="id_title_orselector_id" name="infoConfigs[17].orSelector"  type="text" value="${source.infoConfigs[17].orSelector }" class="input" />
								</td>
								<td>
									<input id="id_title_subreg_id" name="infoConfigs[17].subReg"  type="text" value="${source.infoConfigs[17].subReg }" class="input" />
								</td>
								<td>
									<input name="infoConfigs[17].isResvHtml" value="0" type="radio" <c:if test="${source.infoConfigs[17].isResvHtml=='0' }">checked="checked"</c:if>>是 &nbsp;&nbsp;&nbsp;
									<input name="infoConfigs[17].isResvHtml" value="1" type="radio" <c:if test="${source.infoConfigs[17].isResvHtml=='1' }">checked="checked"</c:if>>否
								</td>
						</tr>
						<tr>
							<td class="label">审批文号：<input type="hidden" name="infoConfigs[18].id" value="${source.infoConfigs[18].id }"></td>
							<td><select name="infoConfigs[18].prop">
									<option value="">--请选择字段名称--</option>
									<c:forEach items="${tableInfos }" var="tableInfo" varStatus="tableInfoStatus">
										<option value="${tableInfo.name}" <c:if test="${source.infoConfigs[18].prop == tableInfo.name }">selected="selected"</c:if>>${tableInfo.name }</option>
									</c:forEach>
								</select></td>
								<td>
									<input id="id_title_selector_id" name="infoConfigs[18].selector"  type="text" value="${source.infoConfigs[18].selector }" class="input" />
								</td>
								<td>
									<input id="id_title_orselector_id" name="infoConfigs[18].orSelector"  type="text" value="${source.infoConfigs[18].orSelector }" class="input" />
								</td>
								<td>
									<input id="id_title_subreg_id" name="infoConfigs[18].subReg"  type="text" value="${source.infoConfigs[18].subReg }" class="input" />
								</td>
								<td>
									<input name="infoConfigs[18].isResvHtml" value="0" type="radio" <c:if test="${source.infoConfigs[18].isResvHtml=='0' }">checked="checked"</c:if>>是 &nbsp;&nbsp;&nbsp;
									<input name="infoConfigs[18].isResvHtml" value="1" type="radio" <c:if test="${source.infoConfigs[18].isResvHtml=='1' }">checked="checked"</c:if>>否
								</td>
						</tr>
						<tr>
							<td class="label">审批时间：<input type="hidden" name="infoConfigs[19].id" value="${source.infoConfigs[19].id }"></td>
							<td><select name="infoConfigs[19].prop">
									<option value="">--请选择字段名称--</option>
									<c:forEach items="${tableInfos }" var="tableInfo" varStatus="tableInfoStatus">
										<option value="${tableInfo.name}" <c:if test="${source.infoConfigs[19].prop == tableInfo.name }">selected="selected"</c:if>>${tableInfo.name }</option>
									</c:forEach>
								</select></td>
								<td>
									<input id="id_title_selector_id" name="infoConfigs[19].selector"  type="text" value="${source.infoConfigs[19].selector }" class="input" />
								</td>
								<td>
									<input id="id_title_orselector_id" name="infoConfigs[19].orSelector"  type="text" value="${source.infoConfigs[19].orSelector }" class="input" />
								</td>
								<td>
									<input id="id_title_subreg_id" name="infoConfigs[19].subReg"  type="text" value="${source.infoConfigs[19].subReg }" class="input" />
								</td>
								<td>
									<input name="infoConfigs[19].isResvHtml" value="0" type="radio" <c:if test="${source.infoConfigs[19].isResvHtml=='0' }">checked="checked"</c:if>>是 &nbsp;&nbsp;&nbsp;
									<input name="infoConfigs[19].isResvHtml" value="1" type="radio" <c:if test="${source.infoConfigs[19].isResvHtml=='1' }">checked="checked"</c:if>>否
								</td>
						</tr>
						</tbody>
						
						<tr>
						    <td class="label">
							   	 &nbsp;
							</td>
							<td>
								<button class="btn" type="button" onclick="modifySource();">确定</button>
								<button class="btn" type="button" onclick="history.go(-1);" >取消</button>
							</td>
						</tr>
					</table>
				</fieldset>
						
				</div>
				</form>
			</div>
		</div>
		<%@include file="/WEB-INF/views/admin/include_js.jsp" %>
		<script type="text/javascript" src="<%=path %>/back/js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
			//检查form
			function checkForm(){
				
				var siteName = $("#siteName").val();
				var siteUrl = $("#siteUrl").val();
				var startUrl = $("#startUrl").val();
				if(isEmpty(siteName)){
					layer.tips('数据源名称不能为空！', '#siteName', {
					    tips: 2,
					    time:4000
					});
					return false;
				}
				if(isEmpty(siteUrl)){
					layer.tips('数据源地址不能为空！', '#siteUrl', {
					    tips: 2,
					    time:4000
					});
					return false;
				}
				if(isEmpty(startUrl)){
					layer.tips('开始抓取地址不能为空！', '#startUrl', {
					    tips: 2,
					    time:4000
					});
					return false;
				}
				return true;
			}
			
			function modifySource(){
				if(!checkForm){
					return ;
				}
				var srcId = $("#id_src_id").val();
				$.ajax({
					type:'POST',
					url:'<%=path%>/admin/data/modifyInfoCrawlConfig',
					data:$("#id_source_form_id").serializeArray(),
					dataType:'json',
					success:function(msg){
						if(msg.success=='true'){
								layer.alert(msg.message,{icon: 6, closeBtn:2,title:'数据源管理'},function(index){
									window.location.href="<%=path%>/admin/data/viewNewsSource?sourceId="+srcId+"&from=1";
									layer.close(index);
								});
							
						}else if(msg.fail=='true'){
							layer.alert(msg.message,{icon: 5, closeBtn:2,title:'数据源管理'});
						}
					},
					error: function(data) {
						layer.msg(data.message,4,{type:1});
	                }
				});
				
			}
		</script>
	</body>
</html>