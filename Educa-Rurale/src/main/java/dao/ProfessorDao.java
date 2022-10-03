package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Professor;

public class ProfessorDao implements CRUD {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;

	public static void create(Professor professor) {
		sql = "INSERT INTO professores VALUES (null, ?, ?, ? , ?, ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, professor.getNome());
			preparedStatement.setString(2, professor.getTelefone());
			preparedStatement.setString(3, professor.getEmail());
			preparedStatement.setString(4, professor.getFormacao());
			preparedStatement.setString(5, professor.getCpf());

			preparedStatement.executeUpdate();

			System.out.println("Inserção executada no Banco de Dados");

		} catch (SQLException e) {
			System.out.println("A inserção não foi executada no Banco de Dados. " + e.getMessage());
		}
	}

	public static void delete(int professorid_pro) {
		sql = "DELETE FROM professores WHERE id_pro = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, professorid_pro);
			preparedStatement.executeUpdate();

			System.out.println("--Professor deletado com sucesso");

		} catch (SQLException e) {
			System.out.println("--O Professor não foi deletado " + e.getMessage());
		}
	}

	public static List<Professor> find(String pesquisa) {

		sql = String.format("SELECT * FROM professores WHERE nome like '%s%%' OR cpf LIKE '%s%%' ", pesquisa, pesquisa);
		List<Professor> professores = new ArrayList<Professor>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				Professor professor = new Professor();

				professor.setId_pro(resultSet.getInt("id_pro"));
				professor.setNome(resultSet.getString("nome"));
				professor.setTelefone(resultSet.getString("telefone"));
				professor.setEmail(resultSet.getString("email"));
				professor.setFormacao(resultSet.getString("formacao"));
				professor.setCpf(resultSet.getString("cpf"));

				professores.add(professor);

			}

			System.out.println("--Busca de Professores está correta");
			return professores;

		} catch (SQLException e) {
			System.out.println("--Busca de Professores está incorreta " + e.getMessage());
			return null;
		}

	}

	public static Professor findByPk(int professorid_pro) {
		sql = String.format("SELECT * FROM professores WHERE id_pro = %d ", professorid_pro);

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Professor professor = new Professor();

			while (resultSet.next()) {
				professor.setId_pro(resultSet.getInt("id_pro"));
				professor.setNome(resultSet.getString("nome"));
				professor.setTelefone(resultSet.getString("telefone"));
				professor.setEmail(resultSet.getString("email"));
				professor.setFormacao(resultSet.getString("formacao"));
				professor.setCpf(resultSet.getString("cpf"));

			}

			System.out.println("--Professor localizado com sucesso");
			return professor;

		} catch (SQLException e) {

			System.out.println("--O Professor não foi localizado " + e.getMessage());
			return null;
		}
	}

	public static void update(Professor professor) {
		sql = "UPDATE professores SET nome=?, telefone=?, email=?, formacao=?, cpf=?   WHERE id_pro=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, professor.getNome());
			preparedStatement.setString(2, professor.getTelefone());
			preparedStatement.setString(3, professor.getEmail());
			preparedStatement.setString(4, professor.getFormacao());
			preparedStatement.setString(5, professor.getCpf());
			preparedStatement.setInt(6, professor.getId_pro());

			preparedStatement.executeUpdate();

			System.out.println("--Atualização realizada no banco de dados");

		} catch (SQLException e) {
			System.out.println("--Atualização não foi realizada no banco de dados " + e.getMessage());
		}
	}
}
