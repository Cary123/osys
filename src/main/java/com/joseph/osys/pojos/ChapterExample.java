package com.joseph.osys.pojos;

import java.util.ArrayList;
import java.util.List;

public class ChapterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChapterExample() {
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

        public Criteria andChapteridIsNull() {
            addCriterion("ChapterId is null");
            return (Criteria) this;
        }

        public Criteria andChapteridIsNotNull() {
            addCriterion("ChapterId is not null");
            return (Criteria) this;
        }

        public Criteria andChapteridEqualTo(Integer value) {
            addCriterion("ChapterId =", value, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridNotEqualTo(Integer value) {
            addCriterion("ChapterId <>", value, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridGreaterThan(Integer value) {
            addCriterion("ChapterId >", value, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridGreaterThanOrEqualTo(Integer value) {
            addCriterion("ChapterId >=", value, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridLessThan(Integer value) {
            addCriterion("ChapterId <", value, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridLessThanOrEqualTo(Integer value) {
            addCriterion("ChapterId <=", value, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridIn(List<Integer> values) {
            addCriterion("ChapterId in", values, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridNotIn(List<Integer> values) {
            addCriterion("ChapterId not in", values, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridBetween(Integer value1, Integer value2) {
            addCriterion("ChapterId between", value1, value2, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridNotBetween(Integer value1, Integer value2) {
            addCriterion("ChapterId not between", value1, value2, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapternameIsNull() {
            addCriterion("ChapterName is null");
            return (Criteria) this;
        }

        public Criteria andChapternameIsNotNull() {
            addCriterion("ChapterName is not null");
            return (Criteria) this;
        }

        public Criteria andChapternameEqualTo(String value) {
            addCriterion("ChapterName =", value, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameNotEqualTo(String value) {
            addCriterion("ChapterName <>", value, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameGreaterThan(String value) {
            addCriterion("ChapterName >", value, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameGreaterThanOrEqualTo(String value) {
            addCriterion("ChapterName >=", value, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameLessThan(String value) {
            addCriterion("ChapterName <", value, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameLessThanOrEqualTo(String value) {
            addCriterion("ChapterName <=", value, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameLike(String value) {
            addCriterion("ChapterName like", value, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameNotLike(String value) {
            addCriterion("ChapterName not like", value, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameIn(List<String> values) {
            addCriterion("ChapterName in", values, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameNotIn(List<String> values) {
            addCriterion("ChapterName not in", values, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameBetween(String value1, String value2) {
            addCriterion("ChapterName between", value1, value2, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameNotBetween(String value1, String value2) {
            addCriterion("ChapterName not between", value1, value2, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameidIsNull() {
            addCriterion("ChapterNameId is null");
            return (Criteria) this;
        }

        public Criteria andChapternameidIsNotNull() {
            addCriterion("ChapterNameId is not null");
            return (Criteria) this;
        }

        public Criteria andChapternameidEqualTo(Integer value) {
            addCriterion("ChapterNameId =", value, "chapternameid");
            return (Criteria) this;
        }

        public Criteria andChapternameidNotEqualTo(Integer value) {
            addCriterion("ChapterNameId <>", value, "chapternameid");
            return (Criteria) this;
        }

        public Criteria andChapternameidGreaterThan(Integer value) {
            addCriterion("ChapterNameId >", value, "chapternameid");
            return (Criteria) this;
        }

        public Criteria andChapternameidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ChapterNameId >=", value, "chapternameid");
            return (Criteria) this;
        }

        public Criteria andChapternameidLessThan(Integer value) {
            addCriterion("ChapterNameId <", value, "chapternameid");
            return (Criteria) this;
        }

        public Criteria andChapternameidLessThanOrEqualTo(Integer value) {
            addCriterion("ChapterNameId <=", value, "chapternameid");
            return (Criteria) this;
        }

        public Criteria andChapternameidIn(List<Integer> values) {
            addCriterion("ChapterNameId in", values, "chapternameid");
            return (Criteria) this;
        }

        public Criteria andChapternameidNotIn(List<Integer> values) {
            addCriterion("ChapterNameId not in", values, "chapternameid");
            return (Criteria) this;
        }

        public Criteria andChapternameidBetween(Integer value1, Integer value2) {
            addCriterion("ChapterNameId between", value1, value2, "chapternameid");
            return (Criteria) this;
        }

        public Criteria andChapternameidNotBetween(Integer value1, Integer value2) {
            addCriterion("ChapterNameId not between", value1, value2, "chapternameid");
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

        public Criteria andVideourlIsNull() {
            addCriterion("VideoUrl is null");
            return (Criteria) this;
        }

        public Criteria andVideourlIsNotNull() {
            addCriterion("VideoUrl is not null");
            return (Criteria) this;
        }

        public Criteria andVideourlEqualTo(String value) {
            addCriterion("VideoUrl =", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlNotEqualTo(String value) {
            addCriterion("VideoUrl <>", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlGreaterThan(String value) {
            addCriterion("VideoUrl >", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlGreaterThanOrEqualTo(String value) {
            addCriterion("VideoUrl >=", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlLessThan(String value) {
            addCriterion("VideoUrl <", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlLessThanOrEqualTo(String value) {
            addCriterion("VideoUrl <=", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlLike(String value) {
            addCriterion("VideoUrl like", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlNotLike(String value) {
            addCriterion("VideoUrl not like", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlIn(List<String> values) {
            addCriterion("VideoUrl in", values, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlNotIn(List<String> values) {
            addCriterion("VideoUrl not in", values, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlBetween(String value1, String value2) {
            addCriterion("VideoUrl between", value1, value2, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlNotBetween(String value1, String value2) {
            addCriterion("VideoUrl not between", value1, value2, "videourl");
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