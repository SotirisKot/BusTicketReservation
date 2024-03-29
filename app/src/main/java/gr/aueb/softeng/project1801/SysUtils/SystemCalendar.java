package gr.aueb.softeng.project1801.SysUtils;

import java.util.Calendar;

public class SystemCalendar implements  Comparable<SystemCalendar> {

        private static final long MILLIS_PER_DAY = 86400000;
        private Calendar date;

        /**
         *
         * Constructor.
         * @param year (required) year of the calendar.
         * @param month (required) month of the calendar.
         * @param day (required) day of the calendar.
         */
        public SystemCalendar(int year, int month, int day) {
            date = Calendar.getInstance();
            date.set(year, month - 1, day);
            trimToDays(this.date);
        }

        /**
         *
         * Constructor.
         * @param date (required) date of the calendar.
         */
        public SystemCalendar(Calendar date) {
            this.date = Calendar.getInstance();
            this.date.setTimeInMillis(date.getTimeInMillis());
            trimToDays(this.date);
        }

        /**
         * This method trims a specific date into days.
         * @param javaDate ,the date
         */
        private void trimToDays(Calendar javaDate) {
            javaDate.set(Calendar.HOUR_OF_DAY, 0);
            javaDate.set(Calendar.MINUTE, 0);
            javaDate.set(Calendar.SECOND, 0);
            javaDate.set(Calendar.MILLISECOND, 0);
        }

        /**
         * This method computes the duration of a specific date into days.
         * @param other ,a system calendar date that we want to calculate the duration
         * @return the number of days,if it returns positive number of days
         * means the other date is later, while the opposite is negative.
         */
        public long durationInDays(SystemCalendar other) {
            long timeDiff = other.date.getTimeInMillis() - date.getTimeInMillis();
            return timeDiff / MILLIS_PER_DAY;
        }

        /** @return Year of the calendar */
        public int getYear() {
            return date.get(Calendar.YEAR);
        }

        /** @return Month of the calendar */
        public int getMonth() {
            return date.get(Calendar.MONTH) + 1;
        }

        /** @return DayOfMonth of the calendar */
        public int getDayOfMonth() {
            return date.get(Calendar.DAY_OF_MONTH);
        }

        /** @return DayOfWeek of the calendar */
        public int getDayOfWeek() {
            return date.get(Calendar.DAY_OF_WEEK);
        }


        /**
         * This method checks if a date is later than another date.
         * @param other ,a system calendar date that we want to check
         * @return "true" if the date is later than another date or else "false"
         */
        public boolean after(SystemCalendar other) {
            if (equals(other)) {
                return false;
            }
            return date.after(other.date);
        }


        /**
         * This method checks if a date is prior to another date.
         * @param other ,a system calendar date that we want to check
         * @return "true" if the date is prior to another date or else "false"
         */
        public boolean before(SystemCalendar other) {
            if (equals(other)) {
                return false;
            }
            return date.before(other.date);
        }

        /**
         * This method returns a date with the added days.
         * @param days ,the days we want to add
         * @return the new SystemCalend object with the added days
         */
        public SystemCalendar addDays(int days) {
            Calendar newDate = Calendar.getInstance();
            newDate.setTimeInMillis(date.getTimeInMillis());
            newDate.add(Calendar.DAY_OF_MONTH, days);
            return new SystemCalendar(newDate);
        }


        /**
         * This method returns a new {@code Calendar} date.
         * @return the new Calendar object
         */
        public Calendar getJavaCalendar() {
            Calendar javaCalendar = Calendar.getInstance();
            javaCalendar.setTimeInMillis(date.getTimeInMillis());
            trimToDays(javaCalendar);
            return javaCalendar;
        }

    /**
     * This method helps to compare two SystemCalendar objects.
     * @return a number in order to understand the comparison of two SystemCalendar objects
     */
        public int compareTo(SystemCalendar other) {
            return date.compareTo(other.date);
        }


        /**
         * Comparing two objects.
         *
         * This method checks if two object are the same.
         * @param other must be an object.
         */
        @Override
        public boolean equals(Object other) {
            if (other == null) {
                return false;
            }

            if (this == other) {
                return true;
            }

            if (!(other instanceof SystemCalendar)) {
                return false;
            }

            SystemCalendar theDate = (SystemCalendar) other;

            if (date == null) {
                return theDate.date == null;
            }

            if (getYear() != theDate.getYear()) {
                return false;
            }

            if (getMonth() != theDate.getMonth()) {
                return false;
            }

            if (getDayOfMonth() != theDate.getDayOfMonth()) {
                return false;
            }

            return true;
        }

        /**
         * Getting the hashCode of an object.
         *
         * This method checks if two object has the same hasCode.
         * If the method equals returned "true" the hasCode of the two objects must be the same.
         * If the method equals returned "false" the hasCode of the two objects must not be the same.
         */
        @Override
        public int hashCode() {
            return date == null ? 0 : date.hashCode();
        }
}

