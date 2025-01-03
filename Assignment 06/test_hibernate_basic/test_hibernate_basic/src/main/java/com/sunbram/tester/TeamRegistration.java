package com.sunbram.tester;

import org.hibernate.*;

import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;
import com.sunbeam.entities.Teams;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

public class TeamRegistration {
	
	public static void main(String[] args) {
		
		try(SessionFactory sf = getSessionFactory()) {
			
			Scanner sc = new Scanner(System.in);
			
			TeamDao teamDao = new TeamDaoImpl();
			
			System.out.println("Enter team details :-String name, String abbreviation,"
					+ " String owner, int max_player_age, double batting_avg,\r\n"
					+ "			int wicket_taken");
			
			System.out.print("Enter Details here :- ");
			Teams team = new Teams(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextInt());
			
			System.out.println(teamDao.signUpTeam(team));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
