<html>
<body>

	<h2>Contato do usu�rio</h2>
	CPF: <strong>${param.cpf }</strong>
	<form action="${pageContext.request.contextPath}/ServletExemplo" method="post">
		Telefone: <input type="text" name="telefone" /> <input type="submit" />
	</form>

</body>
</html>