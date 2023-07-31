ALTER TABLE document
ADD COLUMN file_data BYTEA;

ALTER TABLE document
DROP COLUMN file_url;
