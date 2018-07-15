package com.joseph.osys.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NoteExample() {
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

        public Criteria andNoteidIsNull() {
            addCriterion("NoteId is null");
            return (Criteria) this;
        }

        public Criteria andNoteidIsNotNull() {
            addCriterion("NoteId is not null");
            return (Criteria) this;
        }

        public Criteria andNoteidEqualTo(Integer value) {
            addCriterion("NoteId =", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidNotEqualTo(Integer value) {
            addCriterion("NoteId <>", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidGreaterThan(Integer value) {
            addCriterion("NoteId >", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidGreaterThanOrEqualTo(Integer value) {
            addCriterion("NoteId >=", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidLessThan(Integer value) {
            addCriterion("NoteId <", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidLessThanOrEqualTo(Integer value) {
            addCriterion("NoteId <=", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidIn(List<Integer> values) {
            addCriterion("NoteId in", values, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidNotIn(List<Integer> values) {
            addCriterion("NoteId not in", values, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidBetween(Integer value1, Integer value2) {
            addCriterion("NoteId between", value1, value2, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidNotBetween(Integer value1, Integer value2) {
            addCriterion("NoteId not between", value1, value2, "noteid");
            return (Criteria) this;
        }

        public Criteria andNotetimeIsNull() {
            addCriterion("NoteTime is null");
            return (Criteria) this;
        }

        public Criteria andNotetimeIsNotNull() {
            addCriterion("NoteTime is not null");
            return (Criteria) this;
        }

        public Criteria andNotetimeEqualTo(Date value) {
            addCriterion("NoteTime =", value, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeNotEqualTo(Date value) {
            addCriterion("NoteTime <>", value, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeGreaterThan(Date value) {
            addCriterion("NoteTime >", value, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("NoteTime >=", value, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeLessThan(Date value) {
            addCriterion("NoteTime <", value, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeLessThanOrEqualTo(Date value) {
            addCriterion("NoteTime <=", value, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeIn(List<Date> values) {
            addCriterion("NoteTime in", values, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeNotIn(List<Date> values) {
            addCriterion("NoteTime not in", values, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeBetween(Date value1, Date value2) {
            addCriterion("NoteTime between", value1, value2, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeNotBetween(Date value1, Date value2) {
            addCriterion("NoteTime not between", value1, value2, "notetime");
            return (Criteria) this;
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

        public Criteria andCreaterIsNull() {
            addCriterion("Creater is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("Creater is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("Creater =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("Creater <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("Creater >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("Creater >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("Creater <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("Creater <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("Creater like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("Creater not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("Creater in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("Creater not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("Creater between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("Creater not between", value1, value2, "creater");
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