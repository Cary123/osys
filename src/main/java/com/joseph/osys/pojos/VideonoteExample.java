package com.joseph.osys.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VideonoteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VideonoteExample() {
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
            addCriterion("noteId is null");
            return (Criteria) this;
        }

        public Criteria andNoteidIsNotNull() {
            addCriterion("noteId is not null");
            return (Criteria) this;
        }

        public Criteria andNoteidEqualTo(Integer value) {
            addCriterion("noteId =", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidNotEqualTo(Integer value) {
            addCriterion("noteId <>", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidGreaterThan(Integer value) {
            addCriterion("noteId >", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidGreaterThanOrEqualTo(Integer value) {
            addCriterion("noteId >=", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidLessThan(Integer value) {
            addCriterion("noteId <", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidLessThanOrEqualTo(Integer value) {
            addCriterion("noteId <=", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidIn(List<Integer> values) {
            addCriterion("noteId in", values, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidNotIn(List<Integer> values) {
            addCriterion("noteId not in", values, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidBetween(Integer value1, Integer value2) {
            addCriterion("noteId between", value1, value2, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidNotBetween(Integer value1, Integer value2) {
            addCriterion("noteId not between", value1, value2, "noteid");
            return (Criteria) this;
        }

        public Criteria andNotetimeIsNull() {
            addCriterion("notetime is null");
            return (Criteria) this;
        }

        public Criteria andNotetimeIsNotNull() {
            addCriterion("notetime is not null");
            return (Criteria) this;
        }

        public Criteria andNotetimeEqualTo(Date value) {
            addCriterion("notetime =", value, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeNotEqualTo(Date value) {
            addCriterion("notetime <>", value, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeGreaterThan(Date value) {
            addCriterion("notetime >", value, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("notetime >=", value, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeLessThan(Date value) {
            addCriterion("notetime <", value, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeLessThanOrEqualTo(Date value) {
            addCriterion("notetime <=", value, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeIn(List<Date> values) {
            addCriterion("notetime in", values, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeNotIn(List<Date> values) {
            addCriterion("notetime not in", values, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeBetween(Date value1, Date value2) {
            addCriterion("notetime between", value1, value2, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeNotBetween(Date value1, Date value2) {
            addCriterion("notetime not between", value1, value2, "notetime");
            return (Criteria) this;
        }

        public Criteria andChapteridIsNull() {
            addCriterion("chapterid is null");
            return (Criteria) this;
        }

        public Criteria andChapteridIsNotNull() {
            addCriterion("chapterid is not null");
            return (Criteria) this;
        }

        public Criteria andChapteridEqualTo(Integer value) {
            addCriterion("chapterid =", value, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridNotEqualTo(Integer value) {
            addCriterion("chapterid <>", value, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridGreaterThan(Integer value) {
            addCriterion("chapterid >", value, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridGreaterThanOrEqualTo(Integer value) {
            addCriterion("chapterid >=", value, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridLessThan(Integer value) {
            addCriterion("chapterid <", value, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridLessThanOrEqualTo(Integer value) {
            addCriterion("chapterid <=", value, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridIn(List<Integer> values) {
            addCriterion("chapterid in", values, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridNotIn(List<Integer> values) {
            addCriterion("chapterid not in", values, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridBetween(Integer value1, Integer value2) {
            addCriterion("chapterid between", value1, value2, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridNotBetween(Integer value1, Integer value2) {
            addCriterion("chapterid not between", value1, value2, "chapterid");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("creater is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("creater is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("creater =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("creater <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("creater >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("creater >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("creater <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("creater <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("creater like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("creater not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("creater in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("creater not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("creater between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("creater not between", value1, value2, "creater");
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