--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.10
-- Dumped by pg_dump version 9.6.10

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: _choices; Type: TABLE; Schema: public; Owner: rebasedata
--

CREATE TABLE public._choices (
                                 id character varying(1) DEFAULT NULL::character varying,
                                 text character varying(1) DEFAULT NULL::character varying,
                                 poll_id character varying(1) DEFAULT NULL::character varying
);


ALTER TABLE public._choices OWNER TO rebasedata;

--
-- Name: _polls; Type: TABLE; Schema: public; Owner: rebasedata
--

CREATE TABLE public._polls (
                               id character varying(1) DEFAULT NULL::character varying,
                               question character varying(1) DEFAULT NULL::character varying,
                               expiration_date_time character varying(1) DEFAULT NULL::character varying,
                               created_at character varying(1) DEFAULT NULL::character varying,
                               updated_at character varying(1) DEFAULT NULL::character varying,
                               created_by character varying(1) DEFAULT NULL::character varying,
                               updated_by character varying(1) DEFAULT NULL::character varying
);


ALTER TABLE public._polls OWNER TO rebasedata;

--
-- Name: _roles; Type: TABLE; Schema: public; Owner: rebasedata
--

CREATE TABLE public._roles (
                               id character varying(1) DEFAULT NULL::character varying,
                               name character varying(1) DEFAULT NULL::character varying
);


ALTER TABLE public._roles OWNER TO rebasedata;

--
-- Name: _user_roles; Type: TABLE; Schema: public; Owner: rebasedata
--

CREATE TABLE public._user_roles (
                                    user_id character varying(1) DEFAULT NULL::character varying,
                                    role_id character varying(1) DEFAULT NULL::character varying
);


ALTER TABLE public._user_roles OWNER TO rebasedata;

--
-- Name: _users; Type: TABLE; Schema: public; Owner: rebasedata
--

CREATE TABLE public._users (
                               id character varying(1) DEFAULT NULL::character varying,
                               name character varying(1) DEFAULT NULL::character varying,
                               username character varying(1) DEFAULT NULL::character varying,
                               email character varying(1) DEFAULT NULL::character varying,
                               password character varying(1) DEFAULT NULL::character varying,
                               created_at character varying(1) DEFAULT NULL::character varying,
                               updated_at character varying(1) DEFAULT NULL::character varying
);


ALTER TABLE public._users OWNER TO rebasedata;

--
-- Name: _votes; Type: TABLE; Schema: public; Owner: rebasedata
--

CREATE TABLE public._votes (
                               id character varying(1) DEFAULT NULL::character varying,
                               user_id character varying(1) DEFAULT NULL::character varying,
                               poll_id character varying(1) DEFAULT NULL::character varying,
                               choice_id character varying(1) DEFAULT NULL::character varying,
                               created_at character varying(1) DEFAULT NULL::character varying,
                               updated_at character varying(1) DEFAULT NULL::character varying
);


ALTER TABLE public._votes OWNER TO rebasedata;

--
-- Data for Name: _choices; Type: TABLE DATA; Schema: public; Owner: rebasedata
--

COPY public._choices (id, text, poll_id) FROM stdin;
\.


--
-- Data for Name: _polls; Type: TABLE DATA; Schema: public; Owner: rebasedata
--

COPY public._polls (id, question, expiration_date_time, created_at, updated_at, created_by, updated_by) FROM stdin;
\.


--
-- Data for Name: _roles; Type: TABLE DATA; Schema: public; Owner: rebasedata
--

COPY public._roles (id, name) FROM stdin;
\.


--
-- Data for Name: _user_roles; Type: TABLE DATA; Schema: public; Owner: rebasedata
--

COPY public._user_roles (user_id, role_id) FROM stdin;
\.


--
-- Data for Name: _users; Type: TABLE DATA; Schema: public; Owner: rebasedata
--

COPY public._users (id, name, username, email, password, created_at, updated_at) FROM stdin;
\.


--
-- Data for Name: _votes; Type: TABLE DATA; Schema: public; Owner: rebasedata
--

COPY public._votes (id, user_id, poll_id, choice_id, created_at, updated_at) FROM stdin;
\.


--
-- PostgreSQL database dump complete
--

