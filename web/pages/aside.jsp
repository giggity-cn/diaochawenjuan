<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left">
				<p>
					<security:authentication property="principal.username" />
				</p>
				<a href="#"><i class="fa fa-circle text-success"></i> 调查问卷</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index">
				<a href="${pageContext.request.contextPath}/pages/main.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>

			<li class="treeview"><a href="#"> <i class="fa fa-user"></i>
					<span>问卷</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu" style="display: block;">

					<li><a
						href="${pageContext.request.contextPath}/pages/list-add.jsp"> <i
							class="fa fa-circle-o"></i> 添加
					</a>
					</li>
					<li><a
							href="${pageContext.request.contextPath}/qServlet"> <i
							class="fa fa-circle-o"></i> 查看
					</a></li>
					</a>

				</ul>
			</li>

		</ul>
	</section>
	<!-- /.sidebar -->
</aside>