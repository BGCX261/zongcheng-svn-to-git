package com.zcmng.forms;

import com.zcmng.commons.Constants;

public class PaginationForm
{
	private int pageSize = Constants.MAX_PAGE_SIZE;
	private int currentPage = 1;
	private int totalCount;
	
	public int getPageSize() 
	{
		return pageSize;
	}
	
	public void setPageSize(int pageSize) 
	{
		this.pageSize = pageSize;
	}
	
	public int getCurrentPage() 
	{
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) 
	{
		this.currentPage = currentPage;
	}
	
	public int getTotalCount() 
	{
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) 
	{
		this.totalCount = totalCount;
	}
	
	public int[] getPageNumbers()
	{
		int[] pageNumbers;		
		
		if(isMorePages())		
		{
			pageNumbers = new int[Constants.SHOW_PAGE_NUMBER];
			
			if(!needShowFirstPage())
			{
				for(int i=1, j=0; i <= Constants.SHOW_PAGE_NUMBER; i++, j++)
				{
					pageNumbers[j] = i;
				}
			}
			else if(!needShowLastPage())
			{
				for(int i=getTotalPageCount() - Constants.SHOW_PAGE_NUMBER + 1, j=0; i <= getTotalPageCount(); i++, j++)
				{
					pageNumbers[j] = i;
				}				
			}
			else
			{
				int prevPage = getCurrentPage() - 1;
				int nextPage = getCurrentPage() + 1;
				int cursor = 0;
				
				pageNumbers[cursor] = prevPage - 1;
				cursor ++;
				pageNumbers[cursor] = prevPage;
				cursor ++;
				pageNumbers[cursor] = getCurrentPage();
				cursor ++;
				pageNumbers[cursor] = nextPage ;
				cursor ++;
				pageNumbers[cursor] = nextPage + 1;
			}
		}			
		else
		{
			pageNumbers = new int[getTotalPageCount()];
			for(int i=1, j=0; i <= getTotalPageCount(); i++, j++)
			{
				pageNumbers[j] = i;
			}
		}			
		
		return pageNumbers;
	}
	
	private boolean isMorePages()
	{
		return getTotalPageCount() > Constants.SHOW_PAGE_NUMBER;
	}
	
	public int getTotalPageCount()
	{
		return (int)Math.ceil((double)getTotalCount()/getPageSize());
	}
	
	public boolean needShowFirstPage()
	{
		return getCurrentPage() - 1 > 2; 
	}
	
	public boolean needShowLastPage()
	{
		return getTotalPageCount() - getCurrentPage() > 2; 
	}
	
	public int getPageStart()
	{
		return ( getCurrentPage() - 1 ) * pageSize + 1;
	}
	
	public int getPageEnd()
	{
		return getCurrentPage() * pageSize;
	}	
	
//	public static void main(String[] arg)
//	{
//		PaginationUtil util = new PaginationUtil();
//		util.setCurrentPage(5);
//		util.setTotalCount(56);
//		
//		int[] results = util.getPageNumbers();
//		for(int i=0; i<results.length; i++)
//		{
//			System.out.println(results[i]);
//		}		
//	}
}
