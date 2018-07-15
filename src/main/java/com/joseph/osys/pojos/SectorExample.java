package com.joseph.osys.pojos;

import java.util.ArrayList;
import java.util.List;

public class SectorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SectorExample() {
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

        public Criteria andSectoridIsNull() {
            addCriterion("SectorId is null");
            return (Criteria) this;
        }

        public Criteria andSectoridIsNotNull() {
            addCriterion("SectorId is not null");
            return (Criteria) this;
        }

        public Criteria andSectoridEqualTo(Integer value) {
            addCriterion("SectorId =", value, "sectorid");
            return (Criteria) this;
        }

        public Criteria andSectoridNotEqualTo(Integer value) {
            addCriterion("SectorId <>", value, "sectorid");
            return (Criteria) this;
        }

        public Criteria andSectoridGreaterThan(Integer value) {
            addCriterion("SectorId >", value, "sectorid");
            return (Criteria) this;
        }

        public Criteria andSectoridGreaterThanOrEqualTo(Integer value) {
            addCriterion("SectorId >=", value, "sectorid");
            return (Criteria) this;
        }

        public Criteria andSectoridLessThan(Integer value) {
            addCriterion("SectorId <", value, "sectorid");
            return (Criteria) this;
        }

        public Criteria andSectoridLessThanOrEqualTo(Integer value) {
            addCriterion("SectorId <=", value, "sectorid");
            return (Criteria) this;
        }

        public Criteria andSectoridIn(List<Integer> values) {
            addCriterion("SectorId in", values, "sectorid");
            return (Criteria) this;
        }

        public Criteria andSectoridNotIn(List<Integer> values) {
            addCriterion("SectorId not in", values, "sectorid");
            return (Criteria) this;
        }

        public Criteria andSectoridBetween(Integer value1, Integer value2) {
            addCriterion("SectorId between", value1, value2, "sectorid");
            return (Criteria) this;
        }

        public Criteria andSectoridNotBetween(Integer value1, Integer value2) {
            addCriterion("SectorId not between", value1, value2, "sectorid");
            return (Criteria) this;
        }

        public Criteria andSectornameIsNull() {
            addCriterion("SectorName is null");
            return (Criteria) this;
        }

        public Criteria andSectornameIsNotNull() {
            addCriterion("SectorName is not null");
            return (Criteria) this;
        }

        public Criteria andSectornameEqualTo(String value) {
            addCriterion("SectorName =", value, "sectorname");
            return (Criteria) this;
        }

        public Criteria andSectornameNotEqualTo(String value) {
            addCriterion("SectorName <>", value, "sectorname");
            return (Criteria) this;
        }

        public Criteria andSectornameGreaterThan(String value) {
            addCriterion("SectorName >", value, "sectorname");
            return (Criteria) this;
        }

        public Criteria andSectornameGreaterThanOrEqualTo(String value) {
            addCriterion("SectorName >=", value, "sectorname");
            return (Criteria) this;
        }

        public Criteria andSectornameLessThan(String value) {
            addCriterion("SectorName <", value, "sectorname");
            return (Criteria) this;
        }

        public Criteria andSectornameLessThanOrEqualTo(String value) {
            addCriterion("SectorName <=", value, "sectorname");
            return (Criteria) this;
        }

        public Criteria andSectornameLike(String value) {
            addCriterion("SectorName like", value, "sectorname");
            return (Criteria) this;
        }

        public Criteria andSectornameNotLike(String value) {
            addCriterion("SectorName not like", value, "sectorname");
            return (Criteria) this;
        }

        public Criteria andSectornameIn(List<String> values) {
            addCriterion("SectorName in", values, "sectorname");
            return (Criteria) this;
        }

        public Criteria andSectornameNotIn(List<String> values) {
            addCriterion("SectorName not in", values, "sectorname");
            return (Criteria) this;
        }

        public Criteria andSectornameBetween(String value1, String value2) {
            addCriterion("SectorName between", value1, value2, "sectorname");
            return (Criteria) this;
        }

        public Criteria andSectornameNotBetween(String value1, String value2) {
            addCriterion("SectorName not between", value1, value2, "sectorname");
            return (Criteria) this;
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

        public Criteria andPdfurlIsNull() {
            addCriterion("PDFUrl is null");
            return (Criteria) this;
        }

        public Criteria andPdfurlIsNotNull() {
            addCriterion("PDFUrl is not null");
            return (Criteria) this;
        }

        public Criteria andPdfurlEqualTo(String value) {
            addCriterion("PDFUrl =", value, "pdfurl");
            return (Criteria) this;
        }

        public Criteria andPdfurlNotEqualTo(String value) {
            addCriterion("PDFUrl <>", value, "pdfurl");
            return (Criteria) this;
        }

        public Criteria andPdfurlGreaterThan(String value) {
            addCriterion("PDFUrl >", value, "pdfurl");
            return (Criteria) this;
        }

        public Criteria andPdfurlGreaterThanOrEqualTo(String value) {
            addCriterion("PDFUrl >=", value, "pdfurl");
            return (Criteria) this;
        }

        public Criteria andPdfurlLessThan(String value) {
            addCriterion("PDFUrl <", value, "pdfurl");
            return (Criteria) this;
        }

        public Criteria andPdfurlLessThanOrEqualTo(String value) {
            addCriterion("PDFUrl <=", value, "pdfurl");
            return (Criteria) this;
        }

        public Criteria andPdfurlLike(String value) {
            addCriterion("PDFUrl like", value, "pdfurl");
            return (Criteria) this;
        }

        public Criteria andPdfurlNotLike(String value) {
            addCriterion("PDFUrl not like", value, "pdfurl");
            return (Criteria) this;
        }

        public Criteria andPdfurlIn(List<String> values) {
            addCriterion("PDFUrl in", values, "pdfurl");
            return (Criteria) this;
        }

        public Criteria andPdfurlNotIn(List<String> values) {
            addCriterion("PDFUrl not in", values, "pdfurl");
            return (Criteria) this;
        }

        public Criteria andPdfurlBetween(String value1, String value2) {
            addCriterion("PDFUrl between", value1, value2, "pdfurl");
            return (Criteria) this;
        }

        public Criteria andPdfurlNotBetween(String value1, String value2) {
            addCriterion("PDFUrl not between", value1, value2, "pdfurl");
            return (Criteria) this;
        }

        public Criteria andSectornameidIsNull() {
            addCriterion("SectorNameId is null");
            return (Criteria) this;
        }

        public Criteria andSectornameidIsNotNull() {
            addCriterion("SectorNameId is not null");
            return (Criteria) this;
        }

        public Criteria andSectornameidEqualTo(Integer value) {
            addCriterion("SectorNameId =", value, "sectornameid");
            return (Criteria) this;
        }

        public Criteria andSectornameidNotEqualTo(Integer value) {
            addCriterion("SectorNameId <>", value, "sectornameid");
            return (Criteria) this;
        }

        public Criteria andSectornameidGreaterThan(Integer value) {
            addCriterion("SectorNameId >", value, "sectornameid");
            return (Criteria) this;
        }

        public Criteria andSectornameidGreaterThanOrEqualTo(Integer value) {
            addCriterion("SectorNameId >=", value, "sectornameid");
            return (Criteria) this;
        }

        public Criteria andSectornameidLessThan(Integer value) {
            addCriterion("SectorNameId <", value, "sectornameid");
            return (Criteria) this;
        }

        public Criteria andSectornameidLessThanOrEqualTo(Integer value) {
            addCriterion("SectorNameId <=", value, "sectornameid");
            return (Criteria) this;
        }

        public Criteria andSectornameidIn(List<Integer> values) {
            addCriterion("SectorNameId in", values, "sectornameid");
            return (Criteria) this;
        }

        public Criteria andSectornameidNotIn(List<Integer> values) {
            addCriterion("SectorNameId not in", values, "sectornameid");
            return (Criteria) this;
        }

        public Criteria andSectornameidBetween(Integer value1, Integer value2) {
            addCriterion("SectorNameId between", value1, value2, "sectornameid");
            return (Criteria) this;
        }

        public Criteria andSectornameidNotBetween(Integer value1, Integer value2) {
            addCriterion("SectorNameId not between", value1, value2, "sectornameid");
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