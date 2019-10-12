package club.jc4u.xzkt.mapper;

import java.util.List;

import club.jc4u.xzkt.entity.Grade;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface GradeMapper {

	
	@Select("select SUM(grade) from t_grade where stuNum = #{id} and status = 2")
	int selSumOfGradeById(String id);
	
	//上面是老版的
	//查询还没有完成的任务
	@Select("select * from t_grade_unsubmit where stuNum = #{id}")
	List<Grade> selNotCompletedDataById(String id);
	
	//查询还没有提交的任务
	@Select("select * from t_grade where stuNum = #{id} and status = 1 and classId = (SELECT classId FROM `t_chooseclass` where stuNum = #{id}  ORDER BY id DESC LIMIT 1)")
	List<Grade> selNotApprovedDataById(String id);
	
	//查询已完成的任务
	@Select("select * from t_grade where stuNum = #{id} and status = 2 and classId = (SELECT classId FROM `t_chooseclass` where stuNum = #{id}  ORDER BY id DESC LIMIT 1)")
	List<Grade> selCompletedDataById(String id);
	
	//通过id和taskId查询任务详情
	@Select("select * from t_grade where stuNum = #{id} and taskId = #{taskId}")
	Grade selDataByIdAndTaskId(@Param("id") String id, @Param("taskId") String taskId);
	
	//初始化表
	@Insert("insert into t_grade(stuNum,name,taskId,classId) values(#{stuNum},#{name},#{taskId},#{classId})")
	int insInitData(@Param("stuNum") String stuNum, @Param("name") String name, @Param("taskId") String taskId, @Param("classId") String classId);
	
	//将0状态改为1状态并改变相应的值
	@Update("update t_grade set time_submit = #{time_submit},content=#{content},codeFileLink=#{codeFileLink},status=1 where stuNum = #{stuNum} and taskId=#{taskId} and status=0")
	int updDataFromNotCompletedToNotApproved(Grade e);
	
	//将1状态改为2状态并改变相应的值
	@Update("update t_grade set time_currect = #{time_currect},grade=#{grade},comment=#{comment},currector=#{currector} status=2 where stunum = #{stunum} and taskid=#{taskid} and status=1")
	int updDataFromNotApprovedToCompleted(Grade e);
	
	//查询所有的taskid
	@Select("select taskid from t_grade where status = #{status}")
	List<String> selTaskIdByStatus(String status);
	
	@Select("select name,classid,SUM(grade) grade from t_grade where status = 2 and stunum = #{id}")
	Grade selTotalScoreById(String id);
	
	
}
