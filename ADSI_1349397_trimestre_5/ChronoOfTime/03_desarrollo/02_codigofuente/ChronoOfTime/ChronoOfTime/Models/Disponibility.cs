using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class Disponibility
    {
        [Key]
        [Column(Order = 12)]
        public int IDDisponibility { get; set; }

        [Display(Name = "Start Date")]
        [Required(ErrorMessage = "El campo Start Date es obligatorio")]
        public string typeDis { get; set; }
        [Display(Name = "Start Date")]
        [DataType(DataType.Time)]
        [DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = ("{0:HH:mm}"))]
        [Required(ErrorMessage = "El campo Start Date es obligatorio")]
        public DateTime startDate { get; set; }
        [Display(Name ="End Date")]
        [DataType(DataType.Time)]
        [DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = ("{0:HH:mm}"))]
        [Required(ErrorMessage = "El campo Start Date es obligatorio")]
        public DateTime EndDate { get; set; }

        //WorkingDay

        [Display(Name ="Working Day")]
        [Required(ErrorMessage = "El campo Working Day es obligatorio")]
        public int IDinitials { get; set; }
        [ForeignKey("IDinitials")]
        public WorkingDay WorkingDays { get; set; }

        
        
    }
}