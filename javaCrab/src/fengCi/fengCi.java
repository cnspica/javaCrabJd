/*
 * Bob
 * 1163802968@qq.com
 * South China Normal University
 * 2015-12-16
 * ���ܣ�ʵ�ִַ�
 * */
package fengCi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class fengCi {

	//ͣ�ôʴʱ�
	public static final String stopWordTable = "E:\\python\\StopWord.txt";
	public static final String jdCommemt = "E:\\python\\jdHuaweiP8Comment.txt";

	public static void main(String[] args) throws IOException {
	
		//����ͣ�ô��ļ�
		BufferedReader StopWordFileBr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(stopWordTable))));
		
		//�������ͣ�ôʵļ���
		Set<String> stopWordSet = new HashSet<String>();
		
		//���绯ͣ�ôʼ�
		String stopWord = null;
		for(; (stopWord = StopWordFileBr.readLine()) != null;){
			stopWordSet.add(stopWord);
		}
		
		//��������֮ǰץȡ�ľ�������,ע������ʽ
		BufferedReader jdComFileBr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(jdCommemt)), "utf8"));
 
		//�����ִʶ���
		String text =null;
		StringBuffer FT = new StringBuffer();
		try {
			while ((text = jdComFileBr.readLine().toString())!=null) {
			StringReader sr=new StringReader(text);  
	        IKSegmenter ik=new IKSegmenter(sr, true);  
	        Lexeme lex=null;  
	    
	        //�ִ�
	        while((lex=ik.next())!=null){
		        	//ȥ��ͣ�ô�   �Լ������\n,p8
		        	if(stopWordSet.contains(lex.getLexemeText())) {
		        		continue;
		        	}
	//	            System.out.print(lex.getLexemeText()+"\t"); 
		        	FT.append(lex.getLexemeText()+"\r\n");
	        	} 
//	        FT.append("\r\n");
			}
			StopWordFileBr.close();//�ر���
			jdComFileBr.close();
			
		} catch (NullPointerException e) {
			String path = "E:\\python\\jdHuaweiP8FC.txt";
			saveFengci(path,FT.toString());//����
			System.out.println("\r\n"+"�ִ���ɣ�(^.^)");
		}
        
        
	}
	
	
	//����ִ�
	public static void saveFengci(String path,String ci) {
		File file = new File(path);
		try {
			if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter  fwriter = new FileWriter(path,true);
		fwriter.write(ci);
		fwriter.flush();
		fwriter.close();
		} catch (Exception e) {
			System.out.print("�ִ��ڱ�������ʱ�����IO����");
			e.printStackTrace();
		}
		
	}
}