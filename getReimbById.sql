set schema 'ers';

CREATE OR REPLACE FUNCTION get_reimb_by_id(
	user_id INTEGER
)
RETURNS TABLE (
    amount NUMERIC(5,2),
    submitted TIMESTAMP,
    type VARCHAR(10),
    description VARCHAR(250),
    first_name VARCHAR(100),
    last_name VARCHAR(100)
)
AS $$
	BEGIN
        RETURN QUERY
			SELECT reimb_amt, reimb_submitted, typ.reimb_type, reimb_description, eu.user_first_name, eu.user_last_name 
			FROM ers_reimbursement AS reims
			INNER JOIN ers_users AS eu
			ON reims.reimb_author = eu.ers_users_id
			INNER JOIN ers_reimbursement_type AS typ
			ON typ.reimb_type_id = reims.reimb_type_id
			WHERE eu.ers_users_id = user_id;
	END; $$
LANGUAGE plpgsql;