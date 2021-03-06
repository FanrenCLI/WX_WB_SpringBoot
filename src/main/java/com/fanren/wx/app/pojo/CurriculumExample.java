package com.fanren.wx.app.pojo;

import java.util.ArrayList;
import java.util.List;

public class CurriculumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CurriculumExample() {
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

        public Criteria andKcmcIsNull() {
            addCriterion("kcmc is null");
            return (Criteria) this;
        }

        public Criteria andKcmcIsNotNull() {
            addCriterion("kcmc is not null");
            return (Criteria) this;
        }

        public Criteria andKcmcEqualTo(String value) {
            addCriterion("kcmc =", value, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcmcNotEqualTo(String value) {
            addCriterion("kcmc <>", value, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcmcGreaterThan(String value) {
            addCriterion("kcmc >", value, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcmcGreaterThanOrEqualTo(String value) {
            addCriterion("kcmc >=", value, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcmcLessThan(String value) {
            addCriterion("kcmc <", value, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcmcLessThanOrEqualTo(String value) {
            addCriterion("kcmc <=", value, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcmcLike(String value) {
            addCriterion("kcmc like", value, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcmcNotLike(String value) {
            addCriterion("kcmc not like", value, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcmcIn(List<String> values) {
            addCriterion("kcmc in", values, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcmcNotIn(List<String> values) {
            addCriterion("kcmc not in", values, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcmcBetween(String value1, String value2) {
            addCriterion("kcmc between", value1, value2, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcmcNotBetween(String value1, String value2) {
            addCriterion("kcmc not between", value1, value2, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcddIsNull() {
            addCriterion("kcdd is null");
            return (Criteria) this;
        }

        public Criteria andKcddIsNotNull() {
            addCriterion("kcdd is not null");
            return (Criteria) this;
        }

        public Criteria andKcddEqualTo(String value) {
            addCriterion("kcdd =", value, "kcdd");
            return (Criteria) this;
        }

        public Criteria andKcddNotEqualTo(String value) {
            addCriterion("kcdd <>", value, "kcdd");
            return (Criteria) this;
        }

        public Criteria andKcddGreaterThan(String value) {
            addCriterion("kcdd >", value, "kcdd");
            return (Criteria) this;
        }

        public Criteria andKcddGreaterThanOrEqualTo(String value) {
            addCriterion("kcdd >=", value, "kcdd");
            return (Criteria) this;
        }

        public Criteria andKcddLessThan(String value) {
            addCriterion("kcdd <", value, "kcdd");
            return (Criteria) this;
        }

        public Criteria andKcddLessThanOrEqualTo(String value) {
            addCriterion("kcdd <=", value, "kcdd");
            return (Criteria) this;
        }

        public Criteria andKcddLike(String value) {
            addCriterion("kcdd like", value, "kcdd");
            return (Criteria) this;
        }

        public Criteria andKcddNotLike(String value) {
            addCriterion("kcdd not like", value, "kcdd");
            return (Criteria) this;
        }

        public Criteria andKcddIn(List<String> values) {
            addCriterion("kcdd in", values, "kcdd");
            return (Criteria) this;
        }

        public Criteria andKcddNotIn(List<String> values) {
            addCriterion("kcdd not in", values, "kcdd");
            return (Criteria) this;
        }

        public Criteria andKcddBetween(String value1, String value2) {
            addCriterion("kcdd between", value1, value2, "kcdd");
            return (Criteria) this;
        }

        public Criteria andKcddNotBetween(String value1, String value2) {
            addCriterion("kcdd not between", value1, value2, "kcdd");
            return (Criteria) this;
        }

        public Criteria andTeachersIsNull() {
            addCriterion("teachers is null");
            return (Criteria) this;
        }

        public Criteria andTeachersIsNotNull() {
            addCriterion("teachers is not null");
            return (Criteria) this;
        }

        public Criteria andTeachersEqualTo(String value) {
            addCriterion("teachers =", value, "teachers");
            return (Criteria) this;
        }

        public Criteria andTeachersNotEqualTo(String value) {
            addCriterion("teachers <>", value, "teachers");
            return (Criteria) this;
        }

        public Criteria andTeachersGreaterThan(String value) {
            addCriterion("teachers >", value, "teachers");
            return (Criteria) this;
        }

        public Criteria andTeachersGreaterThanOrEqualTo(String value) {
            addCriterion("teachers >=", value, "teachers");
            return (Criteria) this;
        }

        public Criteria andTeachersLessThan(String value) {
            addCriterion("teachers <", value, "teachers");
            return (Criteria) this;
        }

        public Criteria andTeachersLessThanOrEqualTo(String value) {
            addCriterion("teachers <=", value, "teachers");
            return (Criteria) this;
        }

        public Criteria andTeachersLike(String value) {
            addCriterion("teachers like", value, "teachers");
            return (Criteria) this;
        }

        public Criteria andTeachersNotLike(String value) {
            addCriterion("teachers not like", value, "teachers");
            return (Criteria) this;
        }

        public Criteria andTeachersIn(List<String> values) {
            addCriterion("teachers in", values, "teachers");
            return (Criteria) this;
        }

        public Criteria andTeachersNotIn(List<String> values) {
            addCriterion("teachers not in", values, "teachers");
            return (Criteria) this;
        }

        public Criteria andTeachersBetween(String value1, String value2) {
            addCriterion("teachers between", value1, value2, "teachers");
            return (Criteria) this;
        }

        public Criteria andTeachersNotBetween(String value1, String value2) {
            addCriterion("teachers not between", value1, value2, "teachers");
            return (Criteria) this;
        }

        public Criteria andSkbjIsNull() {
            addCriterion("skbj is null");
            return (Criteria) this;
        }

        public Criteria andSkbjIsNotNull() {
            addCriterion("skbj is not null");
            return (Criteria) this;
        }

        public Criteria andSkbjEqualTo(String value) {
            addCriterion("skbj =", value, "skbj");
            return (Criteria) this;
        }

        public Criteria andSkbjNotEqualTo(String value) {
            addCriterion("skbj <>", value, "skbj");
            return (Criteria) this;
        }

        public Criteria andSkbjGreaterThan(String value) {
            addCriterion("skbj >", value, "skbj");
            return (Criteria) this;
        }

        public Criteria andSkbjGreaterThanOrEqualTo(String value) {
            addCriterion("skbj >=", value, "skbj");
            return (Criteria) this;
        }

        public Criteria andSkbjLessThan(String value) {
            addCriterion("skbj <", value, "skbj");
            return (Criteria) this;
        }

        public Criteria andSkbjLessThanOrEqualTo(String value) {
            addCriterion("skbj <=", value, "skbj");
            return (Criteria) this;
        }

        public Criteria andSkbjLike(String value) {
            addCriterion("skbj like", value, "skbj");
            return (Criteria) this;
        }

        public Criteria andSkbjNotLike(String value) {
            addCriterion("skbj not like", value, "skbj");
            return (Criteria) this;
        }

        public Criteria andSkbjIn(List<String> values) {
            addCriterion("skbj in", values, "skbj");
            return (Criteria) this;
        }

        public Criteria andSkbjNotIn(List<String> values) {
            addCriterion("skbj not in", values, "skbj");
            return (Criteria) this;
        }

        public Criteria andSkbjBetween(String value1, String value2) {
            addCriterion("skbj between", value1, value2, "skbj");
            return (Criteria) this;
        }

        public Criteria andSkbjNotBetween(String value1, String value2) {
            addCriterion("skbj not between", value1, value2, "skbj");
            return (Criteria) this;
        }

        public Criteria andWeekTimeIsNull() {
            addCriterion("week_time is null");
            return (Criteria) this;
        }

        public Criteria andWeekTimeIsNotNull() {
            addCriterion("week_time is not null");
            return (Criteria) this;
        }

        public Criteria andWeekTimeEqualTo(String value) {
            addCriterion("week_time =", value, "weekTime");
            return (Criteria) this;
        }

        public Criteria andWeekTimeNotEqualTo(String value) {
            addCriterion("week_time <>", value, "weekTime");
            return (Criteria) this;
        }

        public Criteria andWeekTimeGreaterThan(String value) {
            addCriterion("week_time >", value, "weekTime");
            return (Criteria) this;
        }

        public Criteria andWeekTimeGreaterThanOrEqualTo(String value) {
            addCriterion("week_time >=", value, "weekTime");
            return (Criteria) this;
        }

        public Criteria andWeekTimeLessThan(String value) {
            addCriterion("week_time <", value, "weekTime");
            return (Criteria) this;
        }

        public Criteria andWeekTimeLessThanOrEqualTo(String value) {
            addCriterion("week_time <=", value, "weekTime");
            return (Criteria) this;
        }

        public Criteria andWeekTimeLike(String value) {
            addCriterion("week_time like", value, "weekTime");
            return (Criteria) this;
        }

        public Criteria andWeekTimeNotLike(String value) {
            addCriterion("week_time not like", value, "weekTime");
            return (Criteria) this;
        }

        public Criteria andWeekTimeIn(List<String> values) {
            addCriterion("week_time in", values, "weekTime");
            return (Criteria) this;
        }

        public Criteria andWeekTimeNotIn(List<String> values) {
            addCriterion("week_time not in", values, "weekTime");
            return (Criteria) this;
        }

        public Criteria andWeekTimeBetween(String value1, String value2) {
            addCriterion("week_time between", value1, value2, "weekTime");
            return (Criteria) this;
        }

        public Criteria andWeekTimeNotBetween(String value1, String value2) {
            addCriterion("week_time not between", value1, value2, "weekTime");
            return (Criteria) this;
        }

        public Criteria andDayTimeIsNull() {
            addCriterion("day_time is null");
            return (Criteria) this;
        }

        public Criteria andDayTimeIsNotNull() {
            addCriterion("day_time is not null");
            return (Criteria) this;
        }

        public Criteria andDayTimeEqualTo(String value) {
            addCriterion("day_time =", value, "dayTime");
            return (Criteria) this;
        }

        public Criteria andDayTimeNotEqualTo(String value) {
            addCriterion("day_time <>", value, "dayTime");
            return (Criteria) this;
        }

        public Criteria andDayTimeGreaterThan(String value) {
            addCriterion("day_time >", value, "dayTime");
            return (Criteria) this;
        }

        public Criteria andDayTimeGreaterThanOrEqualTo(String value) {
            addCriterion("day_time >=", value, "dayTime");
            return (Criteria) this;
        }

        public Criteria andDayTimeLessThan(String value) {
            addCriterion("day_time <", value, "dayTime");
            return (Criteria) this;
        }

        public Criteria andDayTimeLessThanOrEqualTo(String value) {
            addCriterion("day_time <=", value, "dayTime");
            return (Criteria) this;
        }

        public Criteria andDayTimeLike(String value) {
            addCriterion("day_time like", value, "dayTime");
            return (Criteria) this;
        }

        public Criteria andDayTimeNotLike(String value) {
            addCriterion("day_time not like", value, "dayTime");
            return (Criteria) this;
        }

        public Criteria andDayTimeIn(List<String> values) {
            addCriterion("day_time in", values, "dayTime");
            return (Criteria) this;
        }

        public Criteria andDayTimeNotIn(List<String> values) {
            addCriterion("day_time not in", values, "dayTime");
            return (Criteria) this;
        }

        public Criteria andDayTimeBetween(String value1, String value2) {
            addCriterion("day_time between", value1, value2, "dayTime");
            return (Criteria) this;
        }

        public Criteria andDayTimeNotBetween(String value1, String value2) {
            addCriterion("day_time not between", value1, value2, "dayTime");
            return (Criteria) this;
        }

        public Criteria andZhouciIsNull() {
            addCriterion("zhouci is null");
            return (Criteria) this;
        }

        public Criteria andZhouciIsNotNull() {
            addCriterion("zhouci is not null");
            return (Criteria) this;
        }

        public Criteria andZhouciEqualTo(String value) {
            addCriterion("zhouci =", value, "zhouci");
            return (Criteria) this;
        }

        public Criteria andZhouciNotEqualTo(String value) {
            addCriterion("zhouci <>", value, "zhouci");
            return (Criteria) this;
        }

        public Criteria andZhouciGreaterThan(String value) {
            addCriterion("zhouci >", value, "zhouci");
            return (Criteria) this;
        }

        public Criteria andZhouciGreaterThanOrEqualTo(String value) {
            addCriterion("zhouci >=", value, "zhouci");
            return (Criteria) this;
        }

        public Criteria andZhouciLessThan(String value) {
            addCriterion("zhouci <", value, "zhouci");
            return (Criteria) this;
        }

        public Criteria andZhouciLessThanOrEqualTo(String value) {
            addCriterion("zhouci <=", value, "zhouci");
            return (Criteria) this;
        }

        public Criteria andZhouciLike(String value) {
            addCriterion("zhouci like", value, "zhouci");
            return (Criteria) this;
        }

        public Criteria andZhouciNotLike(String value) {
            addCriterion("zhouci not like", value, "zhouci");
            return (Criteria) this;
        }

        public Criteria andZhouciIn(List<String> values) {
            addCriterion("zhouci in", values, "zhouci");
            return (Criteria) this;
        }

        public Criteria andZhouciNotIn(List<String> values) {
            addCriterion("zhouci not in", values, "zhouci");
            return (Criteria) this;
        }

        public Criteria andZhouciBetween(String value1, String value2) {
            addCriterion("zhouci between", value1, value2, "zhouci");
            return (Criteria) this;
        }

        public Criteria andZhouciNotBetween(String value1, String value2) {
            addCriterion("zhouci not between", value1, value2, "zhouci");
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