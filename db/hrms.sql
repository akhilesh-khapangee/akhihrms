-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 26, 2014 at 10:42 AM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE  ="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


 /*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */
;
 /*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */
;
 /*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */
;
 /*!40101 SET NAMES utf8 */
;

--
-- Database: `hrms`
--

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE IF NOT EXISTS `department`
             (
                          `department_id`   int(11) NOT NULL AUTO_INCREMENT
                        , `department_name` varchar(30) DEFAULT NULL
                        , PRIMARY KEY (`department_id`)
                        , UNIQUE KEY `department_name` (`department_name`)
             )
             ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=14
;

--
-- Dumping data for table `department`
--

INSERT INTO `department`
       (`department_id`
            , `department_name`
       )
       VALUES
       (11
            , 'Accounting'
       )
     ,
        (12
            , 'Administration'
       )
     ,
        (13
            , 'Software Engineering'
       )
;

-- --------------------------------------------------------

--
-- Table structure for table `designation`
--

CREATE TABLE IF NOT EXISTS `designation`
             (
                          `designation_id`   int(11) NOT NULL AUTO_INCREMENT
                        , `designation_name` varchar(30) DEFAULT NULL
                        , PRIMARY KEY (`designation_id`)
                        , UNIQUE KEY `designation_name` (`designation_name`)
             )
             ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=8
;

--
-- Dumping data for table `designation`
--

INSERT INTO `designation`
       (`designation_id`
            , `designation_name`
       )
       VALUES
       (5
            , 'Receptionist'
       )
     ,
        (7
            , 'Software Analyst'
       )
     ,
        (6
            , 'Software Engineer'
       )
;

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE IF NOT EXISTS `employees`
             (
                          `emp_id`            varchar(15) NOT NULL
                        , `f_name`            varchar(30) DEFAULT NULL
                        , `l_name`            varchar(30) DEFAULT NULL
                        , `gender`            varchar(10) DEFAULT NULL
                        , `department`        varchar(20) DEFAULT NULL
                        , `designation`       varchar(30) DEFAULT NULL
                        , `join_date`         varchar(20) DEFAULT NULL
                        , `job_status`        varchar(20) DEFAULT NULL
                        , `qualification`     varchar(30) DEFAULT NULL
                        , `cell_no`           varchar(30) DEFAULT NULL
                        , `residence_contact` varchar(30) DEFAULT NULL
                        , `email_id`          varchar(30) DEFAULT NULL
                        , `address`           varchar(30) DEFAULT NULL
                        , PRIMARY KEY (`emp_id`)
             )
             ENGINE=InnoDB DEFAULT CHARSET=latin1
;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees`
       (`emp_id`
            , `f_name`
            , `l_name`
            , `gender`
            , `department`
            , `designation`
            , `join_date`
            , `job_status`
            , `qualification`
            , `cell_no`
            , `residence_contact`
            , `email_id`
            , `address`
       )
       VALUES
       ('emp1'
            , 'Akhilesh'
            , 'Khapangee'
            , 'Male'
            , 'Software Engineering'
            , 'Software Developer'
            , '2014-02-13'
            , 'Full time contract'
            , 'BSc Software Engineering'
            , '9849429054'
            , '014811241'
            , 'connect.akhi@yahoo.com'
            , 'Kathmandu, Nepal'
       )
     ,
        ('emp2'
            , 'Ankita'
            , 'Paudel Updated'
            , 'Male'
            , 'Software Engineering'
            , 'Software Engineer'
            , '2014-06-11'
            , 'Full time contract'
            , 'BSc Software Engineering'
            , '9849542652'
            , 'Birgunj'
            , 'ankita@yahoo.com'
            , 'Kathmandu, Nepal'
       )
     ,
        ('emp3'
            , 'Rashmi'
            , 'Thapa'
            , 'Female'
            , 'Accounting'
            , 'Accountant'
            , '2014-06-16'
            , 'Full time contract'
            , 'BBS'
            , '9845262352'
            , '0148562444'
            , 'rashmi.f@yahoo.com'
            , 'Samakhusi, Nepal'
       )
     ,
        ('emp4'
            , 'John'
            , 'Hassall'
            , 'Male'
            , 'Administration'
            , 'Software Engineer'
            , '2014-06-11'
            , 'Full time contract'
            , 'BSc Software Engineering'
            , '9849429054'
            , '01-48241'
            , 'john.hassall@nccedu.com'
            , 'Kathmandu, Nepal'
       )
     ,
        ('emp5'
            , 'Ram'
            , 'Thapa'
            , 'Male'
            , 'Accounting'
            , 'Receptionist'
            , '2014-06-25'
            , 'Full time Internship'
            , 'BSc Computing'
            , '9847526542'
            , '01-1548575'
            , 'ram@yahoo.com'
            , 'Kathmandu, Nepal'
       )
;

-- --------------------------------------------------------

--
-- Table structure for table `leave_request`
--

CREATE TABLE IF NOT EXISTS `leave_request`
             (
                          `id`         int(11) NOT NULL AUTO_INCREMENT
                        , `emp_id`     varchar(30) DEFAULT NULL
                        , `leave_type` varchar(20) DEFAULT NULL
                        , `from`       varchar(20) DEFAULT NULL
                        , `to`         varchar(20) DEFAULT NULL
                        , `status`     varchar(20) DEFAULT NULL
                        , `leave_purpose` text
                        , PRIMARY KEY (`id`)
             )
             ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=26
;

--
-- Dumping data for table `leave_request`
--

INSERT INTO `leave_request`
       (`id`
            , `emp_id`
            , `leave_type`
            , `from`
            , `to`
            , `status`
            , `leave_purpose`
       )
       VALUES
       (14
            , 'emp1'
            , 'Sick leave'
            , '2014-06-17'
            , '2014-06-11'
            , 'approved'
            , 'i am suffering form sever head ache.'
       )
     ,
        (15
            , 'emp1'
            , 'Sick Leave'
            , '2014-06-17'
            , '2014-06-10'
            , 'declined'
            , 'I am so sick. I am so sick. I am so sick. I am so sick. I am so sick. '
       )
     ,
        (16
            , 'emp2'
            , 'Casual Leave'
            , '2014-06-10'
            , '2014-06-12'
            , 'approved'
            , 'I am sisk I am sisk I am sisk I am sisk I am sisk I am sisk I am sisk '
       )
     ,
        (17
            , 'emp2'
            , 'Casual Leave'
            , '2014-06-10'
            , '2014-06-12'
            , 'declined'
            , 'I am sisk I am sisk I am sisk I am sisk I am sisk I am sisk I am sisk '
       )
     ,
        (18
            , 'emp2'
            , 'Casual Leave'
            , '2014-06-10'
            , '2014-06-12'
            , 'approved'
            , 'I am sisk I am sisk I am sisk I am sisk I am sisk I am sisk I am sisk '
       )
     ,
        (19
            , 'emp2'
            , 'Casual Leave'
            , '2014-06-03'
            , '2014-06-18'
            , 'approved'
            , 'fsdfdsf'
       )
     ,
        (20
            , 'emp2'
            , 'Casual Leave'
            , '2014-06-03'
            , '2014-06-18'
            , 'approved'
            , ' i am sick  i am sick  i am sick  i am sick  i am sick  i am sick '
       )
     ,
        (21
            , 'emp1'
            , 'Sick Leave'
            , '2014-06-03'
            , '2014-06-04'
            , 'approved'
            , 'im so sick im so sick im so sick im so sick im so sick im so sick '
       )
     ,
        (22
            , 'emp1'
            , 'Casual Leave'
            , '2014-06-03'
            , '2014-06-10'
            , 'declined'
            , 'fdsfd'
       )
     ,
        (23
            , 'emp1'
            , 'Casual Leave'
            , '2014-06-10'
            , '2014-06-03'
            , 'declined'
            , 'sdfsdf'
       )
     ,
        (24
            , 'emp1'
            , 'Sick Leave'
            , '2014-06-11'
            , '2014-06-27'
            , 'approved'
            , 'I am suffering from headache.'
       )
     ,
        (25
            , 'emp5'
            , 'Other'
            , '2014-06-27'
            , '2014-06-30'
            , 'approved'
            , 'I am going to marry...'
       )
;

-- --------------------------------------------------------

--
-- Table structure for table `leave_type`
--

CREATE TABLE IF NOT EXISTS `leave_type`
             (
                          `leave_type_id`   int(11) NOT NULL AUTO_INCREMENT
                        , `leave_type_name` varchar(30) DEFAULT NULL
                        , `leave_rule`      varchar(500) DEFAULT NULL
                        , PRIMARY KEY (`leave_type_id`)
             )
             ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=28
;

--
-- Dumping data for table `leave_type`
--

INSERT INTO `leave_type`
       (`leave_type_id`
            , `leave_type_name`
            , `leave_rule`
       )
       VALUES
       (19
            , 'Casual Leave'
            , 'This is normal type of leave that every employee gets within a working month.'
       )
     ,
        (26
            , 'Sick Leave'
            , 'you can take this leave in the case you are sick and can not come to office.'
       )
     ,
        (27
            , 'Other'
            , 'The kinds of sick leaves may be anything. You have to have specific reason to take this leave.'
       )
;

-- --------------------------------------------------------

--
-- Table structure for table `project_details`
--

CREATE TABLE IF NOT EXISTS `project_details`
             (
                          `project_detail_id` int(11) NOT NULL AUTO_INCREMENT
                        , `project_name`      varchar(30) DEFAULT NULL
                        , `start_date`        date DEFAULT NULL
                        , `end_date`          date DEFAULT NULL
                        , PRIMARY KEY (`project_detail_id`)
                        , UNIQUE KEY `project_name` (`project_name`)
                        , UNIQUE KEY `project_name_2` (`project_name`)
             )
             ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=17
;

--
-- Dumping data for table `project_details`
--

INSERT INTO `project_details`
       (`project_detail_id`
            , `project_name`
            , `start_date`
            , `end_date`
       )
       VALUES
       (14
            , 'LMS'
            , '2014-06-22'
            , '2014-09-09'
       )
     ,
        (15
            , 'HRMS'
            , '2014-10-17'
            , '2014-12-12'
       )
     ,
        (16
            , 'Android App dev'
            , '2014-06-11'
            , '2014-06-11'
       )
;

-- --------------------------------------------------------

--
-- Table structure for table `project_task_details`
--

CREATE TABLE IF NOT EXISTS `project_task_details`
             (
                          `id`           int(11) NOT NULL AUTO_INCREMENT
                        , `project_name` varchar(30) DEFAULT NULL
                        , `task_name`    varchar(30) DEFAULT NULL
                        , `employee`     varchar(30) DEFAULT NULL
                        , `progress_update` text
                        , `task_desc` text
                        , PRIMARY KEY (`id`)
             )
             ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=13
;

--
-- Dumping data for table `project_task_details`
--

INSERT INTO `project_task_details`
       (`id`
            , `project_name`
            , `task_name`
            , `employee`
            , `progress_update`
            , `task_desc`
       )
       VALUES
       (7
            , 'LMS'
            , 'LMS Database Design'
            , 'Akhilesh Khapangee'
            , NULL
            , 'I complted almost all the parts........'
       )
     ,
        (9
            , 'LMS'
            , 'LMS Database Design'
            , 'Ankita Paudel'
            , NULL
            , 'This is UI desing'
       )
     ,
        (10
            , 'HRMS'
            , 'HRMS Analysis'
            , 'Akhilesh Khapangee'
            , NULL
            , 'fsdfsdfsdf'
       )
     ,
        (11
            , 'HRMS'
            , 'HRMS Design'
            , 'Rashmi Thapa'
            , NULL
            , 'I almost completed the task..'
       )
     ,
        (12
            , 'Android App dev'
            , 'Android App Design'
            , 'Akhilesh Khapangee'
            , NULL
            , 'I almost completed half of the work i.e. android app design as you had.....\r\nAjhai yeit baski'
       )
;

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

CREATE TABLE IF NOT EXISTS `task`
             (
                          `task_id`   int(11) NOT NULL AUTO_INCREMENT
                        , `task_name` varchar(30) DEFAULT NULL
                        , PRIMARY KEY (`task_id`)
             )
             ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=8
;

--
-- Dumping data for table `task`
--

INSERT INTO `task`
       (`task_id`
            , `task_name`
       )
       VALUES
       (3
            , 'LMS UI Design'
       )
     ,
        (4
            , 'LMS Database Design'
       )
     ,
        (5
            , 'HRMS Design'
       )
     ,
        (6
            , 'HRMS Analysis'
       )
     ,
        (7
            , 'Android App Design'
       )
;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users`
             (
                          `userName` varchar(20) NOT NULL
                        , `password` varchar(20) NOT NULL
                        , `role`     varchar(10) NOT NULL
                        , `id`       varchar(30) DEFAULT NULL
                        , PRIMARY KEY (`userName`)
             )
             ENGINE=InnoDB DEFAULT CHARSET=latin1
;

--
-- Dumping data for table `users`
--

INSERT INTO `users`
       (`userName`
            , `password`
            , `role`
            , `id`
       )
       VALUES
       ('admin'
            , 'admin'
            , 'Admin'
            , 'emp4'
       )
     ,
        ('akhilesh'
            , 'akhilesh'
            , 'Employee'
            , 'emp1'
       )
     ,
        ('ankita'
            , 'ankita'
            , 'Employee'
            , 'emp2'
       )
     ,
        ('chairman'
            , 'chairman'
            , 'Chairman'
            , 'chairman'
       )
     ,
        ('john'
            , 'john'
            , 'Employee'
            , 'emp4'
       )
     ,
        ('rashmi'
            , 'rashmi'
            , 'Employee'
            , 'emp3'
       )
;

 /*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */
;
 /*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */
;
 /*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */
;