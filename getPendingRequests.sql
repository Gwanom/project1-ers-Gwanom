set schema 'ers';

create or replace function get_pending_requests()
returns table (
	id integer,
    amount numeric(5,2),
    description varchar(250),
    first_name varchar(100),
    last_name varchar(100),
    reimb_type varchar(10),
    status varchar(10)
) as $$
	begin
	return query
		select er.reimb_id, er.reimb_amt, er.reimb_description, eu.user_first_name, eu.user_last_name, ert.reimb_type, ers.reimb_status from ers_reimbursement as er
		inner join ers_users as eu on er.reimb_author = eu.ers_users_id
		inner join ers_reimbursement_status as ers on er.reimb_status_id = ers.reimb_status_id
		inner join ers_reimbursement_type as ert on er.reimb_type_id = ert.reimb_type_id
		where er.reimb_status_id = 1;
	end;
$$ language plpgsql;