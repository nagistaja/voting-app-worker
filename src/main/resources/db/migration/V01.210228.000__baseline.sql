--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: answer; Type: TABLE; Schema: public; Owner: bitweb
--

CREATE TABLE public.answer (
    id bigint NOT NULL,
    description character varying(500),
    hidden boolean,
    text character varying(255) NOT NULL,
    question_id bigint NOT NULL
);


ALTER TABLE public.answer OWNER TO bitweb;

--
-- Name: answers_id_seq; Type: SEQUENCE; Schema: public; Owner: bitweb
--

CREATE SEQUENCE public.answers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.answers_id_seq OWNER TO bitweb;

--
-- Name: question; Type: TABLE; Schema: public; Owner: bitweb
--

CREATE TABLE public.question (
    id bigint NOT NULL,
    description character varying(500),
    text character varying(255) NOT NULL,
    survey_id bigint
);


ALTER TABLE public.question OWNER TO bitweb;

--
-- Name: questions_id_seq; Type: SEQUENCE; Schema: public; Owner: bitweb
--

CREATE SEQUENCE public.questions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.questions_id_seq OWNER TO bitweb;

--
-- Name: response; Type: TABLE; Schema: public; Owner: bitweb
--

CREATE TABLE public.response (
    id bigint NOT NULL,
    created_at timestamp without time zone,
    answer_id bigint NOT NULL,
    question_id bigint NOT NULL
);


ALTER TABLE public.response OWNER TO bitweb;

--
-- Name: responses_id_seq; Type: SEQUENCE; Schema: public; Owner: bitweb
--

CREATE SEQUENCE public.responses_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.responses_id_seq OWNER TO bitweb;

--
-- Name: survey; Type: TABLE; Schema: public; Owner: bitweb
--

CREATE TABLE public.survey (
    id bigint NOT NULL,
    closed_at timestamp without time zone,
    description character varying(1000),
    end_date timestamp without time zone,
    name character varying(255) NOT NULL,
    start_date timestamp without time zone,
    started_at timestamp without time zone
);


ALTER TABLE public.survey OWNER TO bitweb;

--
-- Name: surveys_id_seq; Type: SEQUENCE; Schema: public; Owner: bitweb
--

CREATE SEQUENCE public.surveys_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.surveys_id_seq OWNER TO bitweb;

--
-- Data for Name: answer; Type: TABLE DATA; Schema: public; Owner: bitweb
--

COPY public.answer (id, description, hidden, text, question_id) FROM stdin;
1	Cute and independent	\N	Cats	1
2	Loyal goofballs	\N	Dogs	1
\.

--
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: bitweb
--

COPY public.question (id, description, text, survey_id) FROM stdin;
1	Well gonna have two possible answers for this question, cats and dogs	Who do you like most?	1
\.


--
-- Data for Name: response; Type: TABLE DATA; Schema: public; Owner: bitweb
--

COPY public.response (id, created_at, answer_id, question_id) FROM stdin;
\.


--
-- Data for Name: survey; Type: TABLE DATA; Schema: public; Owner: bitweb
--

COPY public.survey (id, closed_at, description, end_date, name, start_date, started_at) FROM stdin;
1	\N	Let's see who's more popular, cats or dogs	\N	Cats & Dogs	\N	2021-02-28 17:16:41.165707
\.


--
-- Name: answers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: bitweb
--

SELECT pg_catalog.setval('public.answers_id_seq', 2, true);


--
-- Name: questions_id_seq; Type: SEQUENCE SET; Schema: public; Owner: bitweb
--

SELECT pg_catalog.setval('public.questions_id_seq', 1, true);


--
-- Name: responses_id_seq; Type: SEQUENCE SET; Schema: public; Owner: bitweb
--

SELECT pg_catalog.setval('public.responses_id_seq', 1, false);


--
-- Name: surveys_id_seq; Type: SEQUENCE SET; Schema: public; Owner: bitweb
--

SELECT pg_catalog.setval('public.surveys_id_seq', 1, true);


--
-- Name: answer answer_pkey; Type: CONSTRAINT; Schema: public; Owner: bitweb
--

ALTER TABLE ONLY public.answer
    ADD CONSTRAINT answer_pkey PRIMARY KEY (id);


--
-- Name: question question_pkey; Type: CONSTRAINT; Schema: public; Owner: bitweb
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT question_pkey PRIMARY KEY (id);


--
-- Name: response response_pkey; Type: CONSTRAINT; Schema: public; Owner: bitweb
--

ALTER TABLE ONLY public.response
    ADD CONSTRAINT response_pkey PRIMARY KEY (id);


--
-- Name: survey survey_pkey; Type: CONSTRAINT; Schema: public; Owner: bitweb
--

ALTER TABLE ONLY public.survey
    ADD CONSTRAINT survey_pkey PRIMARY KEY (id);


--
-- Name: response fk3e7adco6sq6onricr8s3glu62; Type: FK CONSTRAINT; Schema: public; Owner: bitweb
--

ALTER TABLE ONLY public.response
    ADD CONSTRAINT fk3e7adco6sq6onricr8s3glu62 FOREIGN KEY (question_id) REFERENCES public.question(id);


--
-- Name: question fk65ro96jafjvulbqu8ia0pb254; Type: FK CONSTRAINT; Schema: public; Owner: bitweb
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT fk65ro96jafjvulbqu8ia0pb254 FOREIGN KEY (survey_id) REFERENCES public.survey(id);


--
-- Name: answer fk8frr4bcabmmeyyu60qt7iiblo; Type: FK CONSTRAINT; Schema: public; Owner: bitweb
--

ALTER TABLE ONLY public.answer
    ADD CONSTRAINT fk8frr4bcabmmeyyu60qt7iiblo FOREIGN KEY (question_id) REFERENCES public.question(id);


--
-- Name: response fkjsuvuni2m6grg5x7mmngbnj9u; Type: FK CONSTRAINT; Schema: public; Owner: bitweb
--

ALTER TABLE ONLY public.response
    ADD CONSTRAINT fkjsuvuni2m6grg5x7mmngbnj9u FOREIGN KEY (answer_id) REFERENCES public.answer(id);


--
-- PostgreSQL database dump complete
--

