package java201023;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AtricleDao {
// date access object
	private static ArrayList<Article> articles;
	private int no = 3;
	
	public AtricleDao(){
		articles = new ArrayList<>();
		
		Article a1 = new Article(1, "제목1", "내용1", "익명", getCurrentDate());
		Article a2 = new Article(2, "제목2", "내용2", "익명", getCurrentDate());
		
		articles.add(a1);
		articles.add(a2);
	}
	
	public static Article getArticleById(int targetId) {
		for (int i = 0; i < articles.size(); i++) {
			int id = articles.get(i).getId();
			if (id == targetId) {
				return articles.get(i);
			}
		}

		return null;
	}
	
	private static String getCurrentDate() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy.MM.dd");
		Date time = new Date();
		String time1 = format1.format(time);

		return time1;
	}
	
	public void removeArticle(Article a) {
		articles.remove(a);
	}
	
	public void insertArticle(Article a){
		a.setId(no);
		no++;
		articles.add(a);		
	}
	
	public ArrayList<Article> getArticles() {
		return articles;
	}
}
