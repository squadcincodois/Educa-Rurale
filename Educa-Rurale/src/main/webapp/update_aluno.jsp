<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Educa Rurale - Atualizar Aluno</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/font-awesome.css" />
<link rel="stylesheet" href="./css/bootstrap.min.css" />
<link rel="stylesheet" href="./css/style.css" />
<link rel="stylesheet" href="./css/responsive.css" />
<link rel="shortcut icon" href="./img/favicon.png" type="image/x-icon" />
<link rel="stylesheet" class="js-color-style"
	href="./css/colors/color-2.css" />
</head>
<body>
	<!--main wrapper start-->
	<div class="main-wrapper">

		<!--header start-->
		<header class="header">
			<div class="container">
				<div
					class="header-main d-flex justify-content-between align-items-center">
					<div class="header-logo">
						<a href="https://squadcincodois.github.io/educaRurale/index.html"><img
							src="./img/logo.png"></a>
					</div>
					<button type="button"
						class="header-hamburger-btn js-header-menu-toggler">
						<span></span>
					</button>
					<div class="header-backdrop js-header-backdrop"></div>
					<nav class="header-menu js-header-menu">
						<button type="button"
							class="header-close-btn js-header-menu-toggler">
							<i class="fas fa-times"></i>
						</button>
						<ul class="menu">
							<li class="menu-item"><a
								href="https://squadcincodois.github.io/educaRurale/index.html">home</a></li>
							<li class="menu-item"><a href="CreateAluno">Lista de
									Alunos</a></li>
							<li class="menu-item"><a href="CreateProfessor">Lista de
									Professores</a></li>
							<li class="menu-item"><a href="cadastro_aluno.html">Cadastro
									de Aluno</a></li>
							<li class="menu-item"><a href="cadastro_professor.html">Cadastro
									de Professor</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</header>
		<!--header end-->

		<!--breadcrumb start-->
		<div class="breadcrumb-nav">
			<div class="container">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb mb-0">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active" aria-current="page">Atualização</li>
					</ol>
				</nav>
			</div>
		</div>
		<!--breadcrumb end-->

		<div class="container">
			<div class="row">
				<!--update section start-->
				<section class="sign-up section-padding">
					<div class="container">
						<div class="row justify-content-center">
							<div class="col-md-7 col-lg-6 col-xl-5">
								<div class="signup-form box">
									<h2 class="form-title text-center">Atualização de Aluno</h2>
									<form action="CreateAluno" method="GET"
										class="menu-item d-flex">
										<input name="pesquisa" class="form-control me-2" type="search"
											placeholder="Digite o Nome " aria-label="Search">
										<button class="btn btn-block btn-theme" type="submit">Buscar</button>
									</form>
									<form action="AAluno" method="POST">
										<input value="${aluno.id}" name="id" type="number"
											style="visibility: hidden">
										<div class="form-group mt-4">
											<label>Nome</label> <input value="${aluno.nome}" name="nome"
												maxlength="40" type="text" class="form-control">
										</div>
										<div class="form-group">
											<label>Telefone</label> <input value="${aluno.telefone}"
												name="telefone" maxlength="20" type="number"
												class="form-control">
										</div>
										<div class="form-group">
											<label>Idade</label> <input value="${aluno.idade}"
												name="idade" maxlength="20" type="number"
												class="form-control">
										</div>
										<div class="form-group">
											<label>Endereço</label> <input value="${aluno.endereco}"
												name="endereco" maxlength="40" type="text"
												class="form-control">
										</div>
										<div class="form-group">
											<label>CPF</label> <input value="${aluno.cpf}" name="cpf"
												maxlength="11" type="number" class="form-control">
										</div>
										<button type="submit" class="btn btn-block btn-theme btn-form">Atualizar
											Aluno</button>
										<button type="reset" class="btn btn-block btn-theme btn-form">Limpar
											Formulário</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</section>
				<!--update section end-->

			</div>
		</div>
		<!-- JavaScript Bundle with Popper -->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
			crossorigin="anonymous"></script>
</body>
</html>