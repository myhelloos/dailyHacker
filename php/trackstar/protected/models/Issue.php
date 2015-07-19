<?php

/**
 * This is the model class for table "tbl_issue".
 *
 * The followings are the available columns in table 'tbl_issue':
 * @property integer $id
 * @property string $name
 * @property string $description
 * @property integer $project_id
 * @property integer $type_id
 * @property integer $status_id
 * @property integer $owner_id
 * @property integer $requester_id
 * @property string $create_time
 * @property integer $create_user_id
 * @property string $update_time
 * @property integer $update_user_id
 *
 * The followings are the available model relations:
 * @property TblUser $owner
 * @property TblProject $project
 * @property TblUser $requester
 */
class Issue extends CActiveRecord
{
	/**
	* Issue Types
	*/
	const TYPE_BUG = 0;
	const TYPE_FEATURE = 1;
	const TYPE_TASK = 2;

	/**
	* Status Types
	*/
	const STATUS_NOT_STARTED = 0;
	const STATUS_STARTED = 1;
	const STATUS_FINISHED = 2;

	/**
	 * @return string the associated database table name
	 */
	public function tableName()
	{
		return 'tbl_issue';
	}

	/**
	 * @return array validation rules for model attributes.
	 */
	public function rules()
	{
		// NOTE: you should only define rules for those attributes that
		// will receive user inputs.
		return array(
			array('name', 'required'),
			array('project_id, type_id, status_id, owner_id, requester_id, create_user_id, update_user_id', 'numerical', 'integerOnly'=>true),
			array('type_id', 'in', 'range'=>self::getAllowedTypeRange()),
			array('status_id', 'in', 'range'=>self::getAllowedStatusRange()),
			array('name', 'length', 'max'=>255),
			array('description, create_time, update_time', 'safe'),
			// The following rule is used by search().
			// @todo Please remove those attributes that should not be searched.
			array('id, name, description, project_id, type_id, status_id, owner_id, requester_id, create_time, create_user_id, update_time, update_user_id', 'safe', 'on'=>'search'),
		);
	}

	/**
	 * @return array relational rules.
	 */
	public function relations()
	{
		// NOTE: you may need to adjust the relation name and the related
		// class name for the relations automatically generated below.
		return array(
			'owner' => array(self::BELONGS_TO, 'User', 'owner_id'),
			'project' => array(self::BELONGS_TO, 'Project', 'project_id'),
			'requester' => array(self::BELONGS_TO, 'User', 'requester_id'),
		);
	}

	/**
	 * @return array customized attribute labels (name=>label)
	 */
	public function attributeLabels()
	{
		return array(
			'id' => 'ID',
			'name' => 'Name',
			'description' => 'Description',
			'project_id' => 'Project',
			'type_id' => 'Type',
			'status_id' => 'Status',
			'owner_id' => 'Owner',
			'requester_id' => 'Requester',
			'create_time' => 'Create Time',
			'create_user_id' => 'Create User',
			'update_time' => 'Update Time',
			'update_user_id' => 'Update User',
		);
	}

	/**
	 * Retrieves a list of models based on the current search/filter conditions.
	 *
	 * Typical usecase:
	 * - Initialize the model fields with values from filter form.
	 * - Execute this method to get CActiveDataProvider instance which will filter
	 * models according to data in model fields.
	 * - Pass data provider to CGridView, CListView or any similar widget.
	 *
	 * @return CActiveDataProvider the data provider that can return the models
	 * based on the search/filter conditions.
	 */
	public function search()
	{
		// @todo Please modify the following code to remove attributes that should not be searched.

		$criteria=new CDbCriteria;

		$criteria->compare('id',$this->id);
		$criteria->compare('name',$this->name,true);
		$criteria->compare('description',$this->description,true);
		$criteria->compare('project_id',$this->project_id);
		$criteria->compare('type_id',$this->type_id);
		$criteria->compare('status_id',$this->status_id);
		$criteria->compare('owner_id',$this->owner_id);
		$criteria->compare('requester_id',$this->requester_id);
		$criteria->compare('create_time',$this->create_time,true);
		$criteria->compare('create_user_id',$this->create_user_id);
		$criteria->compare('update_time',$this->update_time,true);
		$criteria->compare('update_user_id',$this->update_user_id);

		$criteria->condition = 'project_id=:projectId';
		$criteria->params=array('projectId'=>$this->project_id);

		return new CActiveDataProvider($this, array(
			'criteria'=>$criteria,
		));
	}

	/**
	 * Returns the static model of the specified AR class.
	 * Please note that you should have this exact method in all your CActiveRecord descendants!
	 * @param string $className active record class name.
	 * @return Issue the static model class
	 */
	public static function model($className=__CLASS__)
	{
		return parent::model($className);
	}

	/**
	* Retrives a list of issues Types
	* @return array an array of available issue types.
	*/
	public function getTypeOptions()
	{
		return array(
			self::TYPE_BUG=>'Bug',
			self::TYPE_FEATURE=>'Feature',
			self::TYPE_TASK=>'Task',
		);
	}

	public static function getAllowedTypeRange()
	{
		return array(
			self::TYPE_BUG,
			self::TYPE_FEATURE,
			self::TYPE_TASK,
		);
	}

	/**
	* Retrives a list of status types
	* @return array an array of available status types.
	*/
	public function getStatusOptions()
	{
		return array(
			self::STATUS_NOT_STARTED=>'Not Yet Started',
			self::STATUS_STARTED=>'Started',
			self::STATUS_FINISHED=>'Finished',
		);
	}

	public static function getAllowedStatusRange()
	{
		return array(
			self::STATUS_NOT_STARTED,
			self::STATUS_STARTED,
			self::STATUS_FINISHED,
		);
	}

	/**
	* @return string the status text display for the current issue
	*/
	public function getStatusText()
	{
		$statusOptions = $this->statusOptions;
		return isset($statusOptions[$this->status_id]) ?
			$statusOptions[$this->status_id] : "unkown status ({$this->status_id})";
	}

	/**
	* @return string the type text display for the current issue
	*/
	public function getTypeText()
	{
		$typeOptions = $this->typeOptions;
		return isset($typeOptions[$this->type_id]) ?
			$typeOptions[$this->type_id] : "unkown status ({$this->type_id})";
	}
}
