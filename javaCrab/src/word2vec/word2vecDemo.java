/*
 * Bob
 * 1163802968@qq.com
 * South China Normal University
 * 2015-12-16
 * 
 * ���ܣ���������
 * �ο���https://github.com/NLPchina/Word2VEC_java/blob/master/src/com/ansj/vec/Word2VEC.java
 * */

package word2vec;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import com.ansj.vec.Learn;
import com.ansj.vec.Word2VEC;

public class word2vecDemo {
	public static void main(String[] args) throws IOException{
//		String sougouWordFile ="E:\\python\\FTWord2vec.txt";
//		File sougoufile = new File(sougouWordFile);
//		String huaweiWord ="E:\\python\\jdHuaweiP8FC.txt";
//		File huaweiWordFile = new File(huaweiWord);
//		
//		//��ʼѵ��		
//	    Learn lean = new Learn() ;
//	    lean.setLayerSize(10);
//	    lean.learnFile(sougoufile) ;
//	    lean.learnFile(huaweiWordFile);
//	    lean.saveModel(new File("E:\\python\\vector.mod")) ;

	    //���ز���
	    Word2VEC w2v = new Word2VEC() ;
	    w2v.loadJavaModel("E:\\python\\vector.mod") ;
	    System.out.println("�ֻ��������ǣ�"+Arrays.toString(w2v.getWordVector("�ֻ�")));
	    System.out.println("�ֻ������������ǣ�"+w2v.getWordVector("�ֻ�").length);
	    System.out.println("��\"����\"��صĴ��У�"+w2v.distance("����"));
	}
}
