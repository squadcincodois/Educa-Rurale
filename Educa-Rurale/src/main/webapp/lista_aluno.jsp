<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Educa Rurale - Lista de Alunos</title>
<link rel="stylesheet" href="./css/font-awesome.css" />
<link rel="stylesheet" href="./css/bootstrap.min.css" />
<link rel="stylesheet" href="./css/style.css" />
<link rel="stylesheet" href="./css/responsive.css" />
<link rel="shortcut icon" href="./img/favicon.png" type="image/x-icon" />
<link rel="stylesheet" class="js-color-style"
	href="./css/colors/color-2.css" />
</head>
<body>
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
						<li class="menu-item"><a href="cadastro_professor.html">Cadastro
								de Professor</a></li>
						<li class="menu-item"><a href="cadastro_aluno.html">Cadastro
								de aluno</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</header>
	<!--header end-->
	<br>
	<div class="container">
		<div class="row">
			<div class="cold-md-7">
				<hr>
				<h3>Alunos Cadastrados</h3>
				<hr>
				<form action="CreateAluno" method="GET" class="d-flex">
					<input name="pesquisa" class="form-control me-2" type="search"
						placeholder="Digite o Nome ou CPF" aria-label="Search">
					<button class="btn btn-success btn-theme" type="submit">Buscar</button>
				</form>
				<hr>
				<table class="table box">
					<thead>
						<tr>
							<th>id</th>
							<th>Nome</th>
							<th>Telefone</th>
							<th>Idade</th>
							<th>Endereço</th>
							<th>CPF</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${alunos}" var="aluno">
							<tr>
								<td>${aluno.id}</td>
								<td>${aluno.nome}</td>
								<td>${aluno.telefone}</td>
								<td>${aluno.idade}</td>
								<td>${aluno.endereco}</td>
								<td>${aluno.cpf}</td>
								<td><a href="DAluno?alunoid=${aluno.id}"><button
											class="btn-danger">DELETAR</button> </a></td>
								<td><a href="AAluno?alunoid=${aluno.id}"><button
											class="btn-success">ATUALIZAR</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="cadastro_aluno.html"><button class="btn btn-theme">Voltar
						para o Cadastro de Aluno</button></a>
			</div>
		</div>
	</div>
	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>