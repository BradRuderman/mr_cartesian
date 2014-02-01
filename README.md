hdfs dfs -rm -r /slice/output
hadoop jar SliceOverlap.jar SliceOverlapDriver -libjars /home/cloudera/workspace/SliceOverlap/fastutil-6.5.12.jar /slice/input/ /slice/output

