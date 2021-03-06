package java201026;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ArticleDao {
	private static ArrayList<Article> articles;
	private int no = 4;

	public ArticleDao(){
		articles = new ArrayList<>();
		
		Article a1 = new Article(1, "안녕1", "내용1", "익명", getCurrentDate());
		Article a2 = new Article(2, "반가워2", "내용2", "익명", getCurrentDate());
		Article a3 = new Article(3, "안녕하세요3", "내용3", "익명", getCurrentDate());
		
		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
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

	public ArrayList<Article> getSearchByTitle(String keyword) {

		ArrayList<Article> searchArticle = new ArrayList<>();

		for (int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);
			String str = article.getTitle();
			if (str.contains(keyword)) {
				searchArticle.add(article);
			}
		}
		return searchArticle;
	}
	
	public ArrayList<Article> getSearchBody(String keywordBody) {
		ArrayList<Article> searchArticleBody = new ArrayList<>();

		for (int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);
			String str = article.getTitle();
			if (str.contains(keywordBody)) {
				searchArticleBody.add(article);
			}
		}
		return searchArticleBody;
	}
	

	public void removeArticle(Article a) {
		articles.remove(a);
	}

	public void insertArticle(Article a) {
		a.setId(no);
		no++;
		articles.add(a);
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}
}
