package test;

import java.util.Random;

import sources.*;

public class TestUnion {
	
	private static final int N = 100000000;
	public static void main(String args[]){
		Random rdn = new Random();
		
		//Quick Find -> N = 1x10E6 (more than 1 minute)
		QuickFind qf =  new QuickFind(N);
		System.out.println("Quick find");
		for(int i = 0; i < N; i++)
			qf.union(rdn.nextInt(100),rdn.nextInt(100));
		for(int i = 0; i < N; i++)
			System.out.println(qf.isConnected(rdn.nextInt(100),rdn.nextInt(100)));
		qf =  null;
		
		//Quick Union -> N = 1x10E7 (more than 1 minute)
		QuickUnion qu =  new QuickUnion(N);
		System.out.println("Quick Union");
		for(int i = 0; i < N; i++)
			qu.union(rdn.nextInt(100),rdn.nextInt(100));
		for(int i = 0; i < N; i++)
			System.out.println(qu.isConnected(rdn.nextInt(100),rdn.nextInt(100)));
		qu =  null;
		
		//Quick Union Weighted -> N = 1x10E7 (more than 1 minute)
		QuickUnionWeighted quw = new QuickUnionWeighted(N);
		System.out.println("Quick Union Weighted");
		for(int i = 0; i < N; i++)
			quw.union(rdn.nextInt(100),rdn.nextInt(100));
		for(int i = 0; i < N; i++)
			System.out.println(quw.isConnected(rdn.nextInt(100),rdn.nextInt(100)));
		quw =  null;
		
		//Quick Union Weighted Path Compression -> N = 1x10E8 (more than 1 minute)
		QuickUnionWeighted quwp = new QuickUnionWeighted(N);
		System.out.println("Quick Union Weighted with Path Compression");
		for(int i = 0; i < N; i++)
			quwp.union(rdn.nextInt(100),rdn.nextInt(100));
		for(int i = 0; i < N; i++)
			System.out.println(quwp.isConnected(rdn.nextInt(100),rdn.nextInt(100)));
		quwp = null;
		
	}
}
