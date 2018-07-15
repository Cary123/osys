package com.joseph.osys.pojos;

import java.util.ArrayList;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    
    private int start;//设置分页开始  
    
    private int limit;//设置分页的每页的数量</strong>  
    
    private String keywords;
    
      
    public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public int getStart() {  
        return start;  
    }  
  
    public void setStart(int start) {  
        this.start = start;  
    }  
  
    public int getLimit() {  
        return limit;  
    }  
  
    public void setLimit(int limit) {  
        this.limit = limit;  
    }  

    public BookExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andBookidIsNull() {
            addCriterion("BookId is null");
            return (Criteria) this;
        }

        public Criteria andBookidIsNotNull() {
            addCriterion("BookId is not null");
            return (Criteria) this;
        }

        public Criteria andBookidEqualTo(Integer value) {
            addCriterion("BookId =", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidNotEqualTo(Integer value) {
            addCriterion("BookId <>", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidGreaterThan(Integer value) {
            addCriterion("BookId >", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidGreaterThanOrEqualTo(Integer value) {
            addCriterion("BookId >=", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidLessThan(Integer value) {
            addCriterion("BookId <", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidLessThanOrEqualTo(Integer value) {
            addCriterion("BookId <=", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidIn(List<Integer> values) {
            addCriterion("BookId in", values, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidNotIn(List<Integer> values) {
            addCriterion("BookId not in", values, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidBetween(Integer value1, Integer value2) {
            addCriterion("BookId between", value1, value2, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidNotBetween(Integer value1, Integer value2) {
            addCriterion("BookId not between", value1, value2, "bookid");
            return (Criteria) this;
        }

        public Criteria andBooknameIsNull() {
            addCriterion("BookName is null");
            return (Criteria) this;
        }

        public Criteria andBooknameIsNotNull() {
            addCriterion("BookName is not null");
            return (Criteria) this;
        }

        public Criteria andBooknameEqualTo(String value) {
            addCriterion("BookName =", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotEqualTo(String value) {
            addCriterion("BookName <>", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameGreaterThan(String value) {
            addCriterion("BookName >", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameGreaterThanOrEqualTo(String value) {
            addCriterion("BookName >=", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameLessThan(String value) {
            addCriterion("BookName <", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameLessThanOrEqualTo(String value) {
            addCriterion("BookName <=", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameLike(String value) {
            addCriterion("BookName like", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotLike(String value) {
            addCriterion("BookName not like", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameIn(List<String> values) {
            addCriterion("BookName in", values, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotIn(List<String> values) {
            addCriterion("BookName not in", values, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameBetween(String value1, String value2) {
            addCriterion("BookName between", value1, value2, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotBetween(String value1, String value2) {
            addCriterion("BookName not between", value1, value2, "bookname");
            return (Criteria) this;
        }

        public Criteria andBookimageIsNull() {
            addCriterion("BookImage is null");
            return (Criteria) this;
        }

        public Criteria andBookimageIsNotNull() {
            addCriterion("BookImage is not null");
            return (Criteria) this;
        }

        public Criteria andBookimageEqualTo(String value) {
            addCriterion("BookImage =", value, "bookimage");
            return (Criteria) this;
        }

        public Criteria andBookimageNotEqualTo(String value) {
            addCriterion("BookImage <>", value, "bookimage");
            return (Criteria) this;
        }

        public Criteria andBookimageGreaterThan(String value) {
            addCriterion("BookImage >", value, "bookimage");
            return (Criteria) this;
        }

        public Criteria andBookimageGreaterThanOrEqualTo(String value) {
            addCriterion("BookImage >=", value, "bookimage");
            return (Criteria) this;
        }

        public Criteria andBookimageLessThan(String value) {
            addCriterion("BookImage <", value, "bookimage");
            return (Criteria) this;
        }

        public Criteria andBookimageLessThanOrEqualTo(String value) {
            addCriterion("BookImage <=", value, "bookimage");
            return (Criteria) this;
        }

        public Criteria andBookimageLike(String value) {
            addCriterion("BookImage like", value, "bookimage");
            return (Criteria) this;
        }

        public Criteria andBookimageNotLike(String value) {
            addCriterion("BookImage not like", value, "bookimage");
            return (Criteria) this;
        }

        public Criteria andBookimageIn(List<String> values) {
            addCriterion("BookImage in", values, "bookimage");
            return (Criteria) this;
        }

        public Criteria andBookimageNotIn(List<String> values) {
            addCriterion("BookImage not in", values, "bookimage");
            return (Criteria) this;
        }

        public Criteria andBookimageBetween(String value1, String value2) {
            addCriterion("BookImage between", value1, value2, "bookimage");
            return (Criteria) this;
        }

        public Criteria andBookimageNotBetween(String value1, String value2) {
            addCriterion("BookImage not between", value1, value2, "bookimage");
            return (Criteria) this;
        }

        public Criteria andBookcreaterIsNull() {
            addCriterion("BookCreater is null");
            return (Criteria) this;
        }

        public Criteria andBookcreaterIsNotNull() {
            addCriterion("BookCreater is not null");
            return (Criteria) this;
        }

        public Criteria andBookcreaterEqualTo(String value) {
            addCriterion("BookCreater =", value, "bookcreater");
            return (Criteria) this;
        }

        public Criteria andBookcreaterNotEqualTo(String value) {
            addCriterion("BookCreater <>", value, "bookcreater");
            return (Criteria) this;
        }

        public Criteria andBookcreaterGreaterThan(String value) {
            addCriterion("BookCreater >", value, "bookcreater");
            return (Criteria) this;
        }

        public Criteria andBookcreaterGreaterThanOrEqualTo(String value) {
            addCriterion("BookCreater >=", value, "bookcreater");
            return (Criteria) this;
        }

        public Criteria andBookcreaterLessThan(String value) {
            addCriterion("BookCreater <", value, "bookcreater");
            return (Criteria) this;
        }

        public Criteria andBookcreaterLessThanOrEqualTo(String value) {
            addCriterion("BookCreater <=", value, "bookcreater");
            return (Criteria) this;
        }

        public Criteria andBookcreaterLike(String value) {
            addCriterion("BookCreater like", value, "bookcreater");
            return (Criteria) this;
        }

        public Criteria andBookcreaterNotLike(String value) {
            addCriterion("BookCreater not like", value, "bookcreater");
            return (Criteria) this;
        }

        public Criteria andBookcreaterIn(List<String> values) {
            addCriterion("BookCreater in", values, "bookcreater");
            return (Criteria) this;
        }

        public Criteria andBookcreaterNotIn(List<String> values) {
            addCriterion("BookCreater not in", values, "bookcreater");
            return (Criteria) this;
        }

        public Criteria andBookcreaterBetween(String value1, String value2) {
            addCriterion("BookCreater between", value1, value2, "bookcreater");
            return (Criteria) this;
        }

        public Criteria andBookcreaterNotBetween(String value1, String value2) {
            addCriterion("BookCreater not between", value1, value2, "bookcreater");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}