package club.jc4u.xzkt.mapper;

import java.util.List;

import club.jc4u.xzkt.entity.Grade;
import org.apache.ibatis.annotations.*;


public interface GradeMapper {

	
	@Select("select SUM(grade) from t_grade_completed where stuNum = #{id}")
	int selSumOfGradeById(String id);

	//查询还没有完成的任务
	@Select("select * from t_grade_unsubmit where stuNum = #{id}")
	List<Grade> selNotCompletedDataById(String id);
	
	//查询还没有提交的任务
	@Select("select * from t_grade_uncorrent where stuNum = #{id}")
	List<Grade> selNotApprovedDataById(String id);
	
	//查询已完成的任务
	@Select("select * from t_grade_completed where stuNum = #{id}")
	List<Grade> selCompletedDataById(String id);
	
	//通过id和taskId查询任务详情
	@Select("select * from t_grade_completed where stuNum = #{stuNum} and taskId = #{taskId}")
	Grade selDataByIdAndTaskId(Grade e);

	//插入一条新的作业数据
	@Insert("insert into t_grade_uncorrent values(default,#{stuNum},#{taskId},#{taskFileLink})")
	int insNewUnSubmitData(Grade e);

	//插入一条新的提交数据
	@Insert("insert into t_grade_unsubmit values(default,#{stuNum},#{taskId},#{time_submit},#{content})")
	int insNewUnCorrentData(Grade e);

	//插入一条新的完成数据
	@Insert("insert into t_grade_completed values(default,#{stuNum},#{taskId},#{time_correct},#{corrector},#{content},#{grade},#{comment})")
	int insNewCompletedData(Grade e);
	
	//删除未完成任务
	@Delete("delete from t_grade_uncorrent where stuNum = #{id}")
	int delUnCorrentDataById(String id);

	//删除未提交任务
	@Delete("delete from t_grade_unsubmit where stuNum = #{id}")
	int delUnSubmitDataById(String id);

	//删除未提交任务
	@Delete("delete from t_grade_completed where stuNum = #{id}")
	int delUnCompletedDataById(String id);

	//查找taskid
	@Select("select taskid from t_grade_unsubmit")
	List<String> selUnSubmitTaskId(String status);

	//查找taskid
	@Select("select taskid from t_grade_uncorrent")
	List<String> selUnCorrentTaskId(String status);

	//查找taskid
	@Select("select taskid from t_grade_completed")
	List<String> selCompletedTaskId(String status);
	
	@Select("select * from t_grade_completed where stunum = #{id}")
	Grade selTotalScoreById(String id);
	
	
}
