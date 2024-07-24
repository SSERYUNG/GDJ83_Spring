<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="offcanvas offcanvas-end" data-bs-scroll="true" tabindex="-1"
	id="offcanvasSearch" aria-labelledby="Search">
	<div class="offcanvas-header justify-content-center">
		<button type="button" class="btn-close" data-bs-dismiss="offcanvas"
			aria-label="Close"></button>
	</div>
	<div class="offcanvas-body">

		<div class="order-md-last">
			<h4 class="text-primary text-uppercase mb-3">Search</h4>
			<div class="search-bar border rounded-2 border-dark-subtle">
				<form id="search-form" class="text-center d-flex align-items-center"
					action="" method="">
					<input type="text" class="form-control border-0 bg-transparent"
						placeholder="Search Here" />
					<iconify-icon icon="tabler:search" class="fs-4 me-3"></iconify-icon>
				</form>
			</div>
		</div>
	</div>
</div>

<header>
	<div class="container py-2">
		<div class="row py-4 pb-0 pb-sm-4 align-items-center ">

			<div class="col-sm-4 col-lg-3 text-center text-sm-start">
				<div class="main-logo">
					<a href="/"> <img src="/resources/images/logo.png"
						alt="logo" class="img-fluid">
					</a>
				</div>
			</div>
			<div
				class="col-sm-6 offset-sm-2 offset-md-0 col-lg-5 d-none d-lg-block">
				<div class="search-bar border rounded-2 px-3 border-dark-subtle">
					<form id="search-form"
						class="text-center d-flex align-items-center" action="" method="">
						<input type="text" class="form-control border-0 bg-transparent"
							placeholder="Search for more than 10,000 products" />
						<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
							viewBox="0 0 24 24">
                <path fill="currentColor"
								d="M21.71 20.29L18 16.61A9 9 0 1 0 16.61 18l3.68 3.68a1 1 0 0 0 1.42 0a1 1 0 0 0 0-1.39ZM11 18a7 7 0 1 1 7-7a7 7 0 0 1-7 7Z" />
              </svg>
      
					</form>
				</div>
			</div>
			
			<div class="col-sm-8 col-lg-4 d-flex justify-content-end gap-5 align-items-center mt-4 mt-sm-0 justify-content-center justify-content-sm-end">
				<c:if test="${not empty member}">
				<div class="support-box text-end d-none d-xl-block">
				
					<span class="fs-6 secondary-font text-muted">name</span>
					<h5 class="mb-0"> welcome 🎉${member.member_name}</h5>
				</div>
		</c:if>

			</div>
		</div>
</div>

	<div class="container-fluid">
		<hr class="m-0">
	</div>

	<div class="container">
		<nav class="main-menu d-flex navbar navbar-expand-lg ">

			<div class="d-flex d-lg-none align-items-end mt-3">
				<ul class="d-flex justify-content-end list-unstyled m-0">
					<li><a href="#" class="mx-3" data-bs-toggle="offcanvas"
						data-bs-target="#offcanvasSearch" aria-controls="offcanvasSearch">
							<iconify-icon icon="tabler:search" class="fs-4"></iconify-icon> </span>
					</a></li>
				</ul>

			</div>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
				aria-controls="offcanvasNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="offcanvas offcanvas-end" tabindex="-1"
				id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">

				<div class="offcanvas-header justify-content-center">
					<button type="button" class="btn-close" data-bs-dismiss="offcanvas"
						aria-label="Close"></button>
				</div>
</div>
				<div class="offcanvas-body justify-content-between">
					<select class="filter-categories border-0 mb-0 me-5">
						<option>Category</option>
						<option>Notice</option>
						<option>Product</option>
						<option>Q&A</option>
						<option>My page</option>
					</select>
</div>
					<ul class="navbar-nav menu-list list-unstyled d-flex gap-md-3 mb-0">
						<li class="nav-item"><a href="/" class="nav-link active">🏠Home</a></li>
						<li class="nav-item"><a href="/notice/list" class="nav-link">📢Notice</a></li>
						<li class="nav-item"><a href="/product/list" class="nav-link">🗒️Product</a></li>
						<li class="nav-item"><a href="/qna/list" class="nav-link">📌Q&A</a></li>

						<c:if test="${empty member}">
							<li class="nav-item"><a href="/member/join" class="nav-link">💡Join</a></li>
							<li class="nav-item"><a href="/member/login" class="nav-link">🗝️Login</a></li>
						</c:if>
						<c:if test="${not empty member}">
							<li class="nav-item"><a class="nav-link" href="/member/mypage">🙋‍♂️ My Page</a></li>
							<li class="nav-item"><a class="nav-link" href="/member/logout">🐾Logout</a></li>
							<li class="nav-item"><a class="nav-link" href="/product/wishList">🧺My Cart</a></li>
						</c:if>
					</ul>
		</nav>

	</div>

</header>
