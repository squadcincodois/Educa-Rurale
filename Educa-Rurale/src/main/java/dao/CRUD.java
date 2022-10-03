package dao;

import java.util.List;

import model.Professor;

public interface CRUD {

	public static void create(Professor professor) {
	};

	public static void delete(int professorid_pro) {
	};

	public static List<Professor> find(String pesquisa) {
		return null;
	}

	public static Professor findByPk(int professorid_pro) {
		return null;
	}

	public static void update(Professor professor) {
	}
}
