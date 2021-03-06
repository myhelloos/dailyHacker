"""gravatar md5 hash

Revision ID: adcb47659b9
Revises: 2778bba27aa6
Create Date: 2015-03-18 16:52:22.614103

"""

# revision identifiers, used by Alembic.
revision = 'adcb47659b9'
down_revision = '2778bba27aa6'

from alembic import op
import sqlalchemy as sa


def upgrade():
    ### commands auto generated by Alembic - please adjust! ###
    op.add_column('users', sa.Column('avatar_hash', sa.String(length=32), nullable=True))
    ### end Alembic commands ###


def downgrade():
    ### commands auto generated by Alembic - please adjust! ###
    op.drop_column('users', 'avatar_hash')
    ### end Alembic commands ###
